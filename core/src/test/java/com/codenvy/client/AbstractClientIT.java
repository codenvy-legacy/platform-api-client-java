/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.client;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.codenvy.client.auth.AuthenticationManager;
import com.codenvy.client.auth.Credentials;
import com.codenvy.client.auth.CredentialsProvider;

/**
 * {@link AbstractClient} tests.
 * 
 * @author Kevin Pollet
 */
public class AbstractClientIT extends AbstractIT {
    private final AuthenticationManager dummyAuthenticationManager;

    public AbstractClientIT() {
        final Credentials dummyCredentials = new Credentials.Builder().withUsername(DUMMY_USERNAME)
                                                                      .withPassword(DUMMY_PASSWORD)
                                                                      .build();

        final CredentialsProvider dummyCredentialsProvider = mock(CredentialsProvider.class);

        this.dummyAuthenticationManager =
                                          new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, dummyCredentials,
                                                                    dummyCredentialsProvider, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNewAbstractClientWithNullURL() {
        new AbstractClient(null, "dummyAPI", dummyAuthenticationManager) {
        };
    }

    @Test(expected = NullPointerException.class)
    public void testNewAbstractClientWithNullAPIName() {
        new AbstractClient(REST_API_URL, null, dummyAuthenticationManager) {
        };
    }

    @Test(expected = NullPointerException.class)
    public void testNewAbstractClientWithNullAuthenticationManager() {
        new AbstractClient(REST_API_URL, "dummyAPI", null) {
        };
    }
}
