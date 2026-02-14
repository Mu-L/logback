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

package ch.qos.logback.classic.misc;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SLF4JServiceProviderTest {


    /**
     * Test that SLF4JServiceProvider mechanism is working.
     */
    @Test
    public void testActivationOfLogbackProvider() {
        System.setProperty("logback.configurationFile", "logback-minimal.xml");
        org.slf4j.Logger logger = LoggerFactory.getLogger(SLF4JServiceProviderTest.class);

        LoggerContext loggingContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        assertNotNull(loggingContext);

        Logger root = loggingContext.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        assertEquals(Level.ERROR, root.getLevel());

    }

}
