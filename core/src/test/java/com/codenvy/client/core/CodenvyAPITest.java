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


import com.codenvy.client.CodenvyAPI;
import com.codenvy.client.CodenvyClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test if API loading of {@link com.codenvy.client.CodenvyAPI} find our own implementation
 * @author Florent Benoit
 */
@RunWith(MockitoJUnitRunner.class)
public class CodenvyAPITest {

    @Test
    public void checkFindValidImplementation() {
        CodenvyClient client = CodenvyAPI.getClient();
        assertNotNull(client);

        // Check that we've our implementation and not another one
        assertTrue(client instanceof DefaultCodenvyClient);
    }



}
