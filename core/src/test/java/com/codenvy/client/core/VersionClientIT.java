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
package com.codenvy.client.core;

import com.codenvy.client.model.Version;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * {@linkplain com.codenvy.client.core.DefaultVersionClient Version Client} tests.
 *
 * @author Florent Benoit
 */
public class VersionClientIT extends AbstractIT {


    //@Test
    public void testGetVersion() {
        final Version version = codenvy.version()
                                       .current()
                                       .execute();

        assertNotNull(version);

        assertEquals("Codenvy, S.A.", version.implementationVendor());
        assertNotNull(version.implementationVersion());
        assertEquals("Codenvy, S.A.", version.specificationVendor());
        assertEquals("1.0-beta1", version.specificationVersion());
        assertEquals("Codenvy REST API", version.specificationTitle());
        assertNotNull(version.scmRevision());

    }
}
