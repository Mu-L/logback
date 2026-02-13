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
import java.util.concurrent.CountDownLatch;

class ReconfigurationDoneListener implements ConfigurationEventListener {
    CountDownLatch countDownLatch;

    //ReconfigureOnChangeTask roct;

    ReconfigurationDoneListener(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        //this.roct = aRoct;
    }

    @Override
    public void listen(ConfigurationEvent configurationEvent) {
        if (configurationEvent.getEventType() == ConfigurationEvent.EventType.CONFIGURATION_ENDED_SUCCESSFULLY) {
            countDownLatch.countDown();

//            if (roct == null) {
//                countDownLatch.countDown();
//            } else {
//                Object data = configurationEvent.getData();
//                if (data instanceof ReconfigureOnChangeTask && roct == data) {
//                    countDownLatch.countDown();
//                }
//            }
        }

    }
}
