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

import static com.google.common.base.Preconditions.checkNotNull;
import static javax.ws.rs.client.Entity.json;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;

import com.codenvy.client.auth.AuthenticationManager;
import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.Workspace.WorkspaceRef;

/**
 * The Codenvy workspace API client.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class WorkspaceClient extends AbstractClient {
    /**
     * Constructs an instance of {@link WorkspaceClient}.
     * 
     * @param url the Codenvy platform URL.
     * @param authenticationManager the {@link AuthenticationManager}.
     * @throws NullPointerException if url or authenticationManager parameter is {@code null}.
     */
    WorkspaceClient(String url, AuthenticationManager authenticationManager) {
        super(url, "workspace", authenticationManager);
    }

    /**
     * Retrieves all Codenvy workspaces of the user identified by the authentication token.
     * 
     * @return all Codenvy workspaces never {@code null}.
     * @throws CodenvyException if something goes wrong with the API call.
     */
    public Request<List<Workspace>> all() throws CodenvyException {
        final Invocation request = getWebTarget().path("all")
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<>(request, new GenericType<List<Workspace>>() {
        }, getAuthenticationManager());
    }

    /**
     * Retrieves a Codenvy workspace by it's name.
     * 
     * @param name the workspace name.
     * @return the Codenvy workspace or {@code null} if none.
     * @throws NullPointerException if name parameter is {@code null}.
     * @throws CodenvyException if something goes wrong with the API call.
     */
    public Request<WorkspaceRef> withName(String name) throws CodenvyException {
        checkNotNull(name);

        final Invocation request = getWebTarget().queryParam("name", name)
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<>(request, WorkspaceRef.class, getAuthenticationManager());
    }

    /**
     * Creates the given workspace.
     * 
     * @param workspaceRef the workspace to create.
     * @return the created workspace.
     * @throws NullPointerException if {@link WorkspaceRef} parameter is {@code null}.
     * @throws CodenvyException if something goes wrong with the API call.
     */
    public Request<WorkspaceRef> create(WorkspaceRef workspaceRef) throws CodenvyException {
        checkNotNull(workspaceRef);

        final Invocation request = getWebTarget().request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildPost(json(workspaceRef));

        return new SimpleRequest<>(request, WorkspaceRef.class, getAuthenticationManager());

    }
}
