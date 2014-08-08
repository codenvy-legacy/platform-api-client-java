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


import com.codenvy.client.model.BuilderStatus;
import com.codenvy.client.model.Project;

import java.util.List;

/**
 * @author Florent Benoit
 */
public interface BuilderClient {
    /**
     * Builds the given {@link Project} on codenvy.
     *
     * @param project the project to build.
     * @return the {@link BuilderStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<BuilderStatus> build(Project project);

    /**
     * Gets the status of the builder with the given task id.
     *
     * @param project the project.
     * @param taskId the builder task id.
     * @return the {@link BuilderStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<BuilderStatus> status(Project project, long taskId);

    /**
     * Gets the logs of the builder with the given task id.
     *
     * @param project the project.
     * @param taskId the builder task id.
     * @return the builder logs.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<String> logs(Project project, long taskId);

    /**
     * Cancels the builder with the given task id.
     *
     * @param project the project.
     * @param taskId the builder task id.
     * @return the {@link BuilderStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<BuilderStatus> cancel(Project project, long taskId);

    /**
     * Gets the project builds for the given project
     * @param project the project.
     * @return the different statuses.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<List<BuilderStatus>> builds(Project project);
}
