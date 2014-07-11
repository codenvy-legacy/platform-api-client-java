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
package com.codenvy.client.core;

import static com.google.common.base.Preconditions.checkNotNull;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.ws.rs.client.Invocation;

import com.codenvy.client.BuilderClient;
import com.codenvy.client.Request;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.model.DefaultBuilderStatus;
import com.codenvy.client.model.Project;

/**
 * The Codenvy builder API client.
 * 
 * @author Kevin Pollet
 */
public class DefaultBuilderClient extends AbstractClient implements BuilderClient {
    /**
     * Constructs an instance of {@link DefaultBuilderClient}.
     * 
     * @param url the Codenvy platform URL.
     * @param authenticationManager the {@link AuthenticationManager}.
     * @throws NullPointerException if url or authenticationManager parameter is {@code null}.
     */
    DefaultBuilderClient(String url, AuthenticationManager authenticationManager) {
        super(url, "builder", authenticationManager);
    }

    /**
     * Builds the given {@link com.codenvy.client.core.model.DefaultProject} on codenvy.
     * 
     * @param project the project to build.
     * @return the {@link com.codenvy.client.core.model.DefaultBuilderStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    @Override
    public Request<DefaultBuilderStatus> build(Project project) {
        checkNotNull(project);

        final Invocation request = getWebTarget().path(project.workspaceId())
                                                 .path("build")
                                                 .queryParam("project", project.name())
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildPost(null);

        return new SimpleRequest<>(request, DefaultBuilderStatus.class, getAuthenticationManager());
    }

    /**
     * Gets the status of the builder with the given task id.
     * 
     * @param project the project.
     * @param taskId the builder task id.
     * @return the {@link com.codenvy.client.core.model.DefaultBuilderStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    @Override
    public Request<DefaultBuilderStatus> status(Project project, long taskId) {
        checkNotNull(project);

        final Invocation request = getWebTarget().path(project.workspaceId())
                                                 .path("status")
                                                 .path(String.valueOf(taskId))
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<>(request, DefaultBuilderStatus.class, getAuthenticationManager());
    }

    /**
     * Gets the logs of the builder with the given task id.
     * 
     * @param project the project.
     * @param taskId the builder task id.
     * @return the builder logs.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    @Override
    public Request<String> logs(Project project, long taskId) {
        checkNotNull(project);

        final Invocation request = getWebTarget().path(project.workspaceId())
                                                 .path("logs")
                                                 .path(String.valueOf(taskId))
                                                 .request()
                                                 .accept(TEXT_PLAIN)
                                                 .buildGet();

        return new SimpleRequest<>(request, String.class, getAuthenticationManager());
    }

    /**
     * Cancels the builder with the given task id.
     * 
     * @param project the project.
     * @param taskId the builder task id.
     * @return the {@link com.codenvy.client.core.model.DefaultBuilderStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    @Override
    public Request<DefaultBuilderStatus> cancel(Project project, long taskId) {
        checkNotNull(project);

        final Invocation request = getWebTarget().path(project.workspaceId())
                                                 .path("cancel")
                                                 .path(String.valueOf(taskId))
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<>(request, DefaultBuilderStatus.class, getAuthenticationManager());
    }
}
