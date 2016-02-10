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

import com.codenvy.client.auth.Credentials;
import com.codenvy.client.auth.CredentialsProvider;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.auth.DefaultCredentialsBuilder;

import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * {@link com.codenvy.client.core.AbstractClient} tests.
 * 
 * @author Kevin Pollet
 */
public class AbstractClientIT extends AbstractIT {
    private final AuthenticationManager dummyAuthenticationManager;

    public AbstractClientIT() {
        super();
        final Credentials dummyCredentials = new DefaultCredentialsBuilder().withUsername(DUMMY_USERNAME)
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
