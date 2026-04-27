/*
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2026, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v2.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.core.pattern;

/**
 * A minimal converter which sets up the general interface for derived classes.
 * It also implements the functionality to chain converters in a linked list.
 *
 * @param <E> The type of the event object
 * @author ceki
 */
abstract public class Converter<E> {

    Converter<E> next;

    /**
     * The convert method is responsible for extracting data from the event and
     * returning a formatted string representation.
     * 
     * @param event the event to convert
     * @return the formatted string representation
     */
    public abstract String convert(E event);

    /**
     * Formats the event by calling convert() and appends the resulting string to the provided buffer.
     *
     * @param buf The input buffer where data is appended
     * @param event The event from where data is extracted
     */
    public void write(StringBuilder buf, E event) {
        buf.append(convert(event));
    }

    /**
     * Sets the next converter in the chain.
     * This method can only be called once per converter instance.
     * 
     * @param next the next converter to chain
     * @throws IllegalStateException if next has already been set
     */
    public final void setNext(Converter<E> next) {
        if (this.next != null) {
            throw new IllegalStateException("Next converter has been already set");
        }
        this.next = next;
    }

    /**
     * Gets the next converter in the chain.
     * 
     * @return the next converter, or null if not set
     */
    public final Converter<E> getNext() {
        return next;
    }
}
