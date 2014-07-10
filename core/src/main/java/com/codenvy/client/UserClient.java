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

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.client.Invocation;

import com.codenvy.client.auth.AuthenticationManager;
import com.codenvy.client.model.User;

/**
 * The Codenvy user API client.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class UserClient extends AbstractClient {
    /**
     * Constructs an instance of {@link UserClient}.
     * 
     * @param url the Codenvy platform URL.
     * @param authenticationManager the {@link AuthenticationManager}.
     * @throws NullPointerException if url or authenticationManager parameter is {@code null}.
     */
    UserClient(String url, AuthenticationManager authenticationManager) {
        super(url, "user", authenticationManager);
    }

    /**
     * Returns the current user.
     * 
     * @return the current user.
     */
    public Request<User> current() {
        final Invocation request = getWebTarget().request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<User>(request, User.class, getAuthenticationManager());
    }
}
