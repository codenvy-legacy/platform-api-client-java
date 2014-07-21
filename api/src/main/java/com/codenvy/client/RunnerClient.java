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

import com.codenvy.client.model.Project;
import com.codenvy.client.model.RunnerStatus;

import java.util.List;

/**
 * @author Florent Benoit
 */
public interface RunnerClient {
    /**
     * Runs the given project with a codenvy runner.
     *
     * @param project the project to run.
     * @return the {@link RunnerStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<? extends RunnerStatus> run(Project project);

    /**
     * Stops the project runner with the given process id.
     *
     * @param project the project.
     * @param processId the runner process id.
     * @return the {@link RunnerStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<? extends RunnerStatus> stop(Project project, long processId);

    /**
     * Gets the project runner status with the given process id.
     *
     * @param project the project.
     * @param processId the runner process id.
     * @return the {@link RunnerStatus}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<? extends RunnerStatus> status(Project project, long processId);

    /**
     * Gets the project runner logs with the given process id.
     *
     * @param project the project.
     * @param processId the runner process id.
     * @return the runner logs.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<String> logs(Project project, long processId);

    /**
     * Gets the project processes for the given project
     * @param project the project.
     * @return the different statuses.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<List<? extends RunnerStatus>> processes(Project project);


}
