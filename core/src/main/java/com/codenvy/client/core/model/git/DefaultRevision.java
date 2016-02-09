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

import com.codenvy.client.model.git.Revision;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Implementation of @{link Revision}
 * @author Florent Benoit
 */
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultRevision implements Revision {

    /**
     * Name of the branch
     */
    private String branch;

    /**
     * Id of the revision
     */
    private String id;

    /**
     * Message of the revision
     */
    private String message;

    /**
     * Commit time of the revision
     */
    private long commitTime;

    /**
     * Creates a default revision object
     * @param branch Name of the branch
     * @param id Id of the revision
     * @param message Message of the revision
     * @param commitTime Commit time of the revision
     */
    @JsonCreator
    public DefaultRevision(@JsonProperty("branch") String branch,
                           @JsonProperty("id") String id,
                           @JsonProperty("message") String message,
                           @JsonProperty("commitTime") long commitTime) {
        this.branch = branch;
        this.id = id;
        this.message = message;
        this.commitTime = commitTime;

    }


    /**
     * @return branch name
     */
    @Override
    public String getBranch() {
        return branch;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * @return commit message
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @return time of commit
     */
    @Override
    public long getCommitTime() {
        return commitTime;
    }
}
