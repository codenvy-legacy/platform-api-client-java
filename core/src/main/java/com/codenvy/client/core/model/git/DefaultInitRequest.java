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
package com.codenvy.client.core.model.git;

import com.codenvy.client.model.git.InitRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Implementation of {@link com.codenvy.client.model.git.InitRequest}
 * @author Florent Benoit
 */
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultInitRequest implements InitRequest {

    /**
     * Bare repository ?
     */
    private boolean bare;

    /**
     * Initial Commit ?
     */
    private boolean initCommit;

    /**
     * Working directory
     */
    private String workingDir;

    /**
     * Creates a default init request object
     *
     * @param workingDir
     *         Name of the branch
     * @param bare
     *         Message of the revision
     * @param initCommit
     *         Commit time of the revision
     */
    @JsonCreator
    public DefaultInitRequest(@JsonProperty("workingDir") String workingDir,
                           @JsonProperty("bare") boolean bare,
                           @JsonProperty("initCommit") boolean initCommit) {
        this.workingDir = workingDir;
        this.bare = bare;
        this.initCommit = initCommit;
    }


    /**
     * @return the working directory
     */
    @Override
    public String getWorkingDir() {
        return workingDir;
    }

    /**
     * @return true if the git repository should be a bare repository
     */
    @Override
    public boolean isBare() {
        return bare;
    }

    /**
     * @return true if it's the initial commit
     */
    @Override
    public boolean isInitCommit() {
        return initCommit;
    }

}
