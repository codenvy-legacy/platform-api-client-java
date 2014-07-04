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
package com.codenvy.eclipse.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import com.codenvy.eclipse.client.auth.AuthenticationManager;
import com.codenvy.eclipse.client.auth.TokenInjectorFilter;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * Abstract client class.
 * 
 * @author Kevin Pollet
 */
public abstract class AbstractClient {
    private final WebTarget             webTarget;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructs an instance of {@link AbstractClient}.
     * 
     * @param url the Codenvy platform URL.
     * @param apiName the API name.
     * @param authenticationManager the {@link AuthenticationManager}.
     * @param credentialsStoreFactory the {@linkplain com.codenvy.eclipse.client.store.DataStoreFactory DataStoreFactory}.
     * @throws NullPointerException if url, apiName or authenticationManager parameter is {@code null}.
     */
    AbstractClient(String url,
                   String apiName,
                   AuthenticationManager authenticationManager) {

        checkNotNull(url);
        checkNotNull(apiName);
        checkNotNull(authenticationManager);

        this.authenticationManager = authenticationManager;

        final UriBuilder uriBuilder = UriBuilder.fromUri(url)
                                                .path("api")
                                                .path(apiName);

        this.webTarget = ClientBuilder.newClient()
                                      .target(uriBuilder)
                                      .register(JacksonJsonProvider.class)
                                      .register(TokenInjectorFilter.class);
    }

    /**
     * Returns the client {@link WebTarget} endpoint.
     * 
     * @return the client {@link WebTarget} endpoint.
     */
    public WebTarget getWebTarget() {
        return webTarget;
    }

    /**
     * Returns the {@link AuthenticationManager} used to authenticate.
     * 
     * @return the {@link AuthenticationManager} used for authentication.
     */
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }
}
