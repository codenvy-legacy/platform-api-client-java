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
package com.codenvy.client;


import com.codenvy.client.model.BuilderStatus;
import com.codenvy.client.model.ProjectReference;

import java.util.List;

/**
 * @author Florent Benoit
 */
public interface BuilderClient {
    /**
     * Builds the given {@link com.codenvy.client.model.ProjectReference} on codenvy.
     *
     * @param projectReference
     *         the project to build.
     * @return the {@link BuilderStatus}.
     * @throws NullPointerException
     *         if project parameter is {@code null}.
     */
    Request<BuilderStatus> build(ProjectReference projectReference);

    /**
     * Gets the status of the builder with the given task id.
     *
     * @param projectReference
     *         the project.
     * @param taskId
     *         the builder task id.
     * @return the {@link BuilderStatus}.
     * @throws NullPointerException
     *         if project parameter is {@code null}.
     */
    Request<BuilderStatus> status(ProjectReference projectReference, long taskId);

    /**
     * Gets the logs of the builder with the given task id.
     *
     * @param projectReference
     *         the project.
     * @param taskId
     *         the builder task id.
     * @return the builder logs.
     * @throws NullPointerException
     *         if project parameter is {@code null}.
     */
    Request<String> logs(ProjectReference projectReference, long taskId);

    /**
     * Cancels the builder with the given task id.
     *
     * @param projectReference
     *         the project.
     * @param taskId
     *         the builder task id.
     * @return the {@link BuilderStatus}.
     * @throws NullPointerException
     *         if project parameter is {@code null}.
     */
    Request<BuilderStatus> cancel(ProjectReference projectReference, long taskId);

    /**
     * Gets the project builds for the given project
     *
     * @param projectReference
     *         the project.
     * @return the different statuses.
     * @throws NullPointerException
     *         if project parameter is {@code null}.
     */
    Request<List<BuilderStatus>> builds(ProjectReference projectReference);
}
