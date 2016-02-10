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
import com.codenvy.client.WorkspaceClient;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.model.DefaultWorkspace;
import com.codenvy.client.model.Workspace;
import com.google.common.reflect.TypeToken;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import java.lang.reflect.Type;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static javax.ws.rs.client.Entity.json;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * The Codenvy workspace API client.
 *
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class DefaultWorkspaceClient extends AbstractClient implements WorkspaceClient {
    /**
     * Constructs an instance of {@link DefaultWorkspaceClient}.
     *
     * @param url
     *         the Codenvy platform URL.
     * @param authenticationManager
     *         the {@link AuthenticationManager}.
     * @throws NullPointerException
     *         if url or authenticationManager parameter is {@code null}.
     */
    DefaultWorkspaceClient(String url, AuthenticationManager authenticationManager) {
        super(url, "workspace", authenticationManager);
    }

    /**
     * Retrieves all Codenvy workspaces of the user identified by the authentication token.
     *
     * @return all Codenvy workspaces never {@code null}.
     */
    @Override
    public Request<List<Workspace>> all() {
        final Invocation request = getWebTarget().path("")
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();
        Type collectionType = new TypeToken<List<DefaultWorkspace>>() {
        }.getType();

        return new SimpleRequest<>(request, new GenericType<List<Workspace>>(collectionType) {
        }, getAuthenticationManager());
    }

    /**
     * Retrieves a Codenvy workspace by it's name.
     *
     * @param name
     *         the workspace name.
     * @return the Codenvy workspace or {@code null} if none.
     * @throws NullPointerException
     *         if name parameter is {@code null}.
     */
    @Override
    public Request<Workspace> withName(String name) {
        checkNotNull(name);

        final Invocation request = getWebTarget().queryParam("name", name)
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<Workspace>(request, DefaultWorkspace.class, getAuthenticationManager());
    }

    /**
     * Creates the given workspace.
     *
     * @param workspaceReference
     *         the workspace to create.
     * @return the created workspace.
     * @throws NullPointerException
     *         if {@link com.codenvy.client.model.Workspace} parameter is {@code null}.
     */
    @Override
    public Request<Workspace> create(Workspace workspaceReference) {
        checkNotNull(workspaceReference);

        final Invocation request = getWebTarget().request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildPost(json(workspaceReference));

        return new SimpleRequest<Workspace>(request, DefaultWorkspace.class, getAuthenticationManager());

    }
}
