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

package ch.qos.logback.classic.blackbox;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.util.CoreVersionUtil;
import ch.qos.logback.core.util.VersionUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The WithOlderCoreVersionCheckTest class is designed to perform a validation test
 * on the compatibility of version dependencies, specifically focusing
 * on the interaction between "logback-classic" and "logback-core" libraries.
 *
 * <p>In particular, it checks that when "logback-core" is older than version 1.5.25,
 * a NoClassDefFoundError is caught.
 * </p>
 *
 * <p>Use the following command to run this test
 * </p>
 *
 * <pre>  mvn install;  # ensure up to date compilation
 * cd logback-classic-blackbox;
 * mvn test -P older-core -Dtest=ch.qos.logback.classic.blackbox.WithOlderCoreVersionCheckTest
 * </pre>
 *
 * @since 1.5.25
 */

public class WithOlderCoreVersionCheckTest {


    // WARNING: do not add other tests to this file without careful consideration

    LoggerContext loggerContext = new LoggerContext();

    @Test
    public void olderCoreVersionTest() {
        String olderCoreVersion = System.getProperty("olderCore", "none");
        assertTrue(olderCoreVersion.startsWith("1.5"));
        try {
            CoreVersionUtil.getCoreVersionBySelfDeclaredProperties();
            fail("Expected Error");
        } catch (NoClassDefFoundError e) {
            // logback-core version is 1.5.24 or older
            System.out.println("Got expected NoClassDefFoundError.");
        } catch (NoSuchMethodError e) {
            // logback-core version is 1.5.25 or older
            System.out.println("Got expected NoSuchFieldError.");
        }
    }




    // WARNING: do not add other tests to this file without careful consideration

}
