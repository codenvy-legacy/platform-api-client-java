/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 *  [2012] - [2016] Codenvy, S.A.
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URL;
import java.net.URLClassLoader;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test if API loading of {@link CodenvyAPI} is working
 *
 * @author Florent Benoit
 */
@RunWith(MockitoJUnitRunner.class)
public class CodenvyAPITest {

    @Test
    public void checkFindValidImplementation() {
        CodenvyClient client = CodenvyAPI.getClient();
        assertNotNull(client);

        assertTrue(client instanceof DummyCodenvyClient);
    }


    @Test(expected = CodenvyException.class)
    public void checkUnableToFindValidImplementation() {
        ClassLoader classLoader = new URLClassLoader(new URL[0], null);
        ClassLoader old = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(classLoader);
            CodenvyAPI.getClient();
            fail("Without having implementation in classpath this has to fail !");
        } finally {
            Thread.currentThread().setContextClassLoader(old);
        }


    }


}
