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

import com.codenvy.client.Request;
import com.codenvy.client.UserClient;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.model.DefaultUser;
import com.codenvy.client.model.User;

import javax.ws.rs.client.Invocation;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * The Codenvy user API client.
 *
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class DefaultUserClient extends AbstractClient implements UserClient {
    /**
     * Constructs an instance of {@link DefaultUserClient}.
     *
     * @param url
     *         the Codenvy platform URL.
     * @param authenticationManager
     *         the {@link AuthenticationManager}.
     * @throws NullPointerException
     *         if url or authenticationManager parameter is {@code null}.
     */
    DefaultUserClient(String url, AuthenticationManager authenticationManager) {
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

        return new SimpleRequest<User>(request, DefaultUser.class, getAuthenticationManager());
    }
}
