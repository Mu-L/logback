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

package ch.qos.logback.classic.blackbox.joran;

import ch.qos.logback.classic.joran.ReconfigureOnChangeTask;
import ch.qos.logback.core.spi.ConfigurationEvent;
import ch.qos.logback.core.spi.ConfigurationEventListener;

import java.util.Objects;

/**
 * A listener implementation that processes configuration events related to
 * the registration of a reconfiguration task.
 *
 * This class listens to configuration events and identifies if a
 * "CHANGE_DETECTOR_REGISTERED" event has occurred. When such an event is detected,
 * it captures and stores the associated {@link ReconfigureOnChangeTask} instance
 * from the event data if it exists.
 *
 * Implements the {@link ConfigurationEventListener} interface.
 */
public class ReconfigurationTaskRegisteredConfigEventListener implements ConfigurationEventListener {

    boolean changeDetectorRegisteredEventOccurred = false;
    ReconfigureOnChangeTask reconfigureOnChangeTask;

    @Override
    public void listen(ConfigurationEvent configurationEvent) {
        if (configurationEvent.getEventType() == ConfigurationEvent.EventType.CHANGE_DETECTOR_REGISTERED) {
            changeDetectorRegisteredEventOccurred = true;
            Object data = configurationEvent.getData();
            if (data instanceof ReconfigureOnChangeTask)
                reconfigureOnChangeTask = (ReconfigureOnChangeTask) data;
        }
    }
}
