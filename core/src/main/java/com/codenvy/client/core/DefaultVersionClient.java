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
import com.codenvy.client.VersionClient;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.model.DefaultVersion;
import com.codenvy.client.model.Version;

import javax.ws.rs.client.Invocation;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * The Codenvy version API client.
 *
 * @author Florent Benoit
 */
public class DefaultVersionClient extends AbstractClient implements VersionClient {

    /**
     * Constructs an instance of {@link com.codenvy.client.core.DefaultVersionClient}.
     *
     * @param url
     *         the Codenvy platform URL.
     * @param authenticationManager
     *         the {@link com.codenvy.client.core.auth.AuthenticationManager}.
     * @throws NullPointerException
     *         if url or authenticationManager parameter is {@code null}.
     */
    DefaultVersionClient(String url, AuthenticationManager authenticationManager) {
        super(url, "", authenticationManager);
    }

    /**
     * Returns the current user.
     *
     * @return the current user.
     */
    public Request<Version> current() {
        final Invocation request = getWebTarget().request()
                                                 .accept(APPLICATION_JSON)
                                                 .build("OPTIONS");

        return new SimpleRequest<Version>(request, DefaultVersion.class, getAuthenticationManager());
    }
}
