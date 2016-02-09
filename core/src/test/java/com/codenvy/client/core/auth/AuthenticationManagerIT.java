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
package com.codenvy.client.core.auth;

import com.codenvy.client.auth.CodenvyAuthenticationException;
import com.codenvy.client.auth.Credentials;
import com.codenvy.client.auth.CredentialsProvider;
import com.codenvy.client.auth.Token;
import com.codenvy.client.core.AbstractIT;
import com.codenvy.client.store.DataStore;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link AuthenticationManager} tests.
 * 
 * @author Kevin Pollet
 */
public class AuthenticationManagerIT extends AbstractIT {
    private final Credentials credentials;
    private final Credentials credentialsWithToken;

    public AuthenticationManagerIT() {
        super();
        this.credentials = new DefaultCredentialsBuilder().withUsername(DUMMY_USERNAME)
                                     .withPassword(DUMMY_PASSWORD)
                                     .build();

        this.credentialsWithToken = new DefaultCredentialsBuilder().withUsername(DUMMY_USERNAME)
                                                                    .withPassword(DUMMY_PASSWORD)
                                                                    .withToken(new DefaultToken(SDK_TOKEN_VALUE))
                                                                    .build();
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("unchecked")
    public void testNewAuthenticationManagerWithNullURL() {
        new AuthenticationManager(null, DUMMY_USERNAME, credentials, mock(CredentialsProvider.class), mock(DataStore.class));
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("unchecked")
    public void testNewAuthenticationManagerWithNullUsername() {
        new AuthenticationManager(REST_API_URL, null, credentials, mock(CredentialsProvider.class), mock(DataStore.class));
    }

    @Test(expected = CodenvyAuthenticationException.class)
    public void testAuthorizeWithNullDataStoreNullCredentialsAndNullCredentialsProvider() {
        final AuthenticationManager authenticationManager = new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, null, null, null);
        authenticationManager.authorize();
    }

    @Test
    public void testAuthorizeWithNullDataStoreNullCredentialsAndCredentialsProvider() {
        final CredentialsProvider credentialsProvider = mock(CredentialsProvider.class);
        when(credentialsProvider.getCredentials(DUMMY_USERNAME)).thenReturn(credentials);

        final AuthenticationManager authenticationManager =
                                                            new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, null,
                                                                                      credentialsProvider, null);
        authenticationManager.authorize();

        verify(credentialsProvider, times(1)).getCredentials(DUMMY_USERNAME);
    }

    @Test
    public void testAuthorizeWithNullDataStoreCredentialsAndCredentialsProvider() {
        final CredentialsProvider credentialsProvider = mock(CredentialsProvider.class);
        final AuthenticationManager authenticationManager =
                                                            new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, credentials,
                                                                                      credentialsProvider, null);

        final Token token = authenticationManager.authorize();

        Assert.assertNotNull(token);
        Assert.assertEquals(new DefaultToken(SDK_TOKEN_VALUE), token);
        verify(credentialsProvider, times(0)).getCredentials(DUMMY_USERNAME);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testAuthorizeWithDataStoreCredentialsAndCredentialsProvider() {
        final CredentialsProvider credentialsProvider = mock(CredentialsProvider.class);
        final DataStore<String, Credentials> credentialsStore = mock(DataStore.class);
        final AuthenticationManager authenticationManager =
                                                            new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, credentials,
                                                                                      credentialsProvider, credentialsStore);

        final Token token = authenticationManager.authorize();

        Assert.assertNotNull(token);
        Assert.assertEquals(new DefaultToken(SDK_TOKEN_VALUE), token);
        verify(credentialsProvider, times(0)).getCredentials(DUMMY_USERNAME);
        verify(credentialsStore, times(1)).put(eq(DUMMY_USERNAME), eq(credentialsWithToken));
    }

    @Test
    public void testGetTokenWithNullDataStore() {
        final AuthenticationManager authenticationManager = new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, null, null, null);

        Assert.assertNull(authenticationManager.getToken());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetTokenWithMissingUsername() {
        final DataStore<String, Credentials> credentialsStore = mock(DataStore.class);
        when(credentialsStore.get(DUMMY_USERNAME)).thenReturn(null);

        final AuthenticationManager authenticationManager =
                                                            new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, null, null,
                                                                                      credentialsStore);
        final Token token = authenticationManager.getToken();

        Assert.assertNull(token);
        verify(credentialsStore, times(1)).get(DUMMY_USERNAME);
        verify(credentialsStore, times(0)).put(anyString(), any(DefaultCredentials.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetTokenWithExistingUsernameAndNullCredentials() {
        final DataStore<String, Credentials> credentialsStore = mock(DataStore.class);
        when(credentialsStore.get(DUMMY_USERNAME)).thenReturn(credentialsWithToken);

        final AuthenticationManager authenticationManager =
                                                            new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, null, null,
                                                                                      credentialsStore);
        final Token token = authenticationManager.getToken();

        Assert.assertEquals(new DefaultToken(SDK_TOKEN_VALUE), token);
        verify(credentialsStore, times(1)).get(DUMMY_USERNAME);
        verify(credentialsStore, times(0)).put(anyString(), any(DefaultCredentials.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetTokenWithExistingUsernameAndCredentials() {
        final DataStore<String, Credentials> credentialsStore = mock(DataStore.class);
        when(credentialsStore.get(DUMMY_USERNAME)).thenReturn(credentialsWithToken);

        final AuthenticationManager authenticationManager =
                                                            new AuthenticationManager(REST_API_URL, DUMMY_USERNAME, credentialsWithToken,
                                                                                      null,
                                                                                      credentialsStore);
        final Token token = authenticationManager.getToken();

        Assert.assertEquals(new DefaultToken(SDK_TOKEN_VALUE), token);
        verify(credentialsStore, times(1)).get(DUMMY_USERNAME);
        verify(credentialsStore, times(1)).put(eq(DUMMY_USERNAME), eq(credentialsWithToken));
    }
}
