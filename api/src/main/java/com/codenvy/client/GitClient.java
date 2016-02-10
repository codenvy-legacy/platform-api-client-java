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

import com.codenvy.client.model.ProjectReference;
import com.codenvy.client.model.git.Log;
import com.codenvy.client.model.git.LogRequest;

/**
 * Client API for dealing with Git REST API.
 *
 * @author Florent Benoit
 */
public interface GitClient {

    /**
     * Retrieves a Git read-only URL for the given project.
     *
     * @param projectReference
     *         the project reference.
     * @return a GIT URL that allow to clone the given project.
     */
    Request<String> readOnlyUrl(ProjectReference projectReference);


    /**
     * Initialize a Git repository for the given project.
     *
     * @param projectReference
     *         the project reference.
     * @return nothing.
     */
    Request<Void> init(ProjectReference projectReference);

    /**
     * Get log data for the given
     *
     * @param projectReference
     *         the project reference.
     * @param logRequest
     *         the log request.
     * @return a log containing all revisions
     */
    Request<Log> log(ProjectReference projectReference, LogRequest logRequest);

}
