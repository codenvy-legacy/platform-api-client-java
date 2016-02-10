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

import com.codenvy.client.CodenvyUnknownHostException;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.auth.DefaultToken;

import org.junit.Test;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import static javax.ws.rs.core.Response.Status.FORBIDDEN;
import static javax.ws.rs.core.Response.Status.OK;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * {@link com.codenvy.client.core.SimpleRequest} tests.
 * 
 * @author Kevin Pollet
 */
public class SimpleRequestTest {
    @Test(expected = NullPointerException.class)
    public void testNewSimpleRequestWithNullRequest() {
        new SimpleRequest<>(null, Response.class, mock(AuthenticationManager.class));
    }

    @Test(expected = NullPointerException.class)
    public void testNewGenericSimpleRequestWithNullRequest() {
        new SimpleRequest<>(null, new GenericType<Response>() {
        }, mock(AuthenticationManager.class));
    }

    @Test(expected = NullPointerException.class)
    public void testNewSimpleRequestWithNullEntityType() {
        new SimpleRequest<>(mock(Invocation.class), (Class< ? >)null, mock(AuthenticationManager.class));
    }

    @Test(expected = NullPointerException.class)
    public void testNewSimpleRequestWithNullGenericEntityType() {
        new SimpleRequest<>(mock(Invocation.class), (GenericType< ? >)null, mock(AuthenticationManager.class));
    }

    @Test(expected = NullPointerException.class)
    public void testNewSimpleRequestWithNullAuthenticationManager() {
        new SimpleRequest<>(mock(Invocation.class), Response.class, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNewGenericSimpleRequestWithNullAuthenticationManager() {
        new SimpleRequest<>(mock(Invocation.class), new GenericType<Response>() {
        }, null);
    }

    @Test
    public void testExecuteWithStoredCredentials() throws URISyntaxException {
        final Response response = mock(Response.class);
        when(response.getStatus()).thenReturn(OK.getStatusCode());

        final Invocation request = mock(Invocation.class);
        when(request.invoke()).thenReturn(response);

        final AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManager.getToken()).thenReturn(new DefaultToken("123123"));

        final SimpleRequest<Response> simpleRequest = new SimpleRequest<>(request, Response.class, authenticationManager);
        simpleRequest.execute();

        verify(authenticationManager, times(1)).getToken();
        verify(authenticationManager, times(0)).authorize();
        verify(authenticationManager, times(0)).refreshToken();
    }

    @Test
    public void testExecuteWithoutStoredCredentials() throws URISyntaxException {
        final Response response = mock(Response.class);
        when(response.getStatus()).thenReturn(OK.getStatusCode());

        final Invocation request = mock(Invocation.class);
        when(request.invoke()).thenReturn(response);

        final AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManager.getToken()).thenReturn(null);
        when(authenticationManager.authorize()).thenReturn(new DefaultToken("123123"));

        final SimpleRequest<Response> simpleRequest = new SimpleRequest<>(request, Response.class, authenticationManager);
        simpleRequest.execute();

        verify(authenticationManager, times(1)).getToken();
        verify(authenticationManager, times(1)).authorize();
        verify(authenticationManager, times(0)).refreshToken();
    }

    @Test
    public void testExecuteWithRefreshAndStoredCredentials() throws URISyntaxException {
        final Response response = mock(Response.class);
        when(response.getStatus()).thenReturn(FORBIDDEN.getStatusCode());

        final Invocation request = mock(Invocation.class);
        when(request.invoke()).thenReturn(response);

        final AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManager.getToken()).thenReturn(new DefaultToken("123123"));

        final SimpleRequest<Response> simpleRequest = new SimpleRequest<>(request, Response.class, authenticationManager);
        simpleRequest.execute();

        verify(authenticationManager, times(1)).getToken();
        verify(authenticationManager, times(0)).authorize();
        verify(authenticationManager, times(1)).refreshToken();
    }

    @Test
    public void testExecuteWithRefreshAndWithoutStoredCredentials() throws URISyntaxException {
        final Response response = mock(Response.class);
        when(response.getStatus()).thenReturn(FORBIDDEN.getStatusCode());

        final Invocation request = mock(Invocation.class);
        when(request.invoke()).thenReturn(response);

        final AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManager.getToken()).thenReturn(null);
        when(authenticationManager.authorize()).thenReturn(new DefaultToken("123123"));

        final SimpleRequest<Response> simpleRequest = new SimpleRequest<>(request, Response.class, authenticationManager);
        simpleRequest.execute();

        verify(authenticationManager, times(1)).getToken();
        verify(authenticationManager, times(1)).authorize();
        verify(authenticationManager, times(1)).refreshToken();
    }

    @Test(expected = CodenvyUnknownHostException.class)
    public void testExecuteWithUnknownHostException() throws URISyntaxException {
        final Invocation request = mock(Invocation.class);
        when(request.invoke()).thenThrow(new ProcessingException(new UnknownHostException("unknown")));

        final AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
        when(authenticationManager.getToken()).thenReturn(new DefaultToken("123123"));

        final SimpleRequest<Response> simpleRequest = new SimpleRequest<>(request, Response.class, authenticationManager);
        simpleRequest.execute();
    }
}
