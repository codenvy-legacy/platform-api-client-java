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
package com.codenvy.client.dummy.builder;

import com.codenvy.client.model.BuilderState;
import com.codenvy.client.model.BuilderStatus;
import com.codenvy.client.model.Link;
import com.codenvy.client.model.builder.BuilderMetric;

import java.util.List;

/**
 * @author Florent Benoit
 */
public class DummyBuilderStatus implements BuilderStatus {

    private long                taskId;
    private long                startTime;
    private BuilderState        status;
    private List<Link>          links;
    private List<BuilderMetric> builderMetrics;
    private String log;

    public DummyBuilderStatus(long taskId) {
        this.taskId = taskId;
        this.status = BuilderState.IN_QUEUE;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void setStatus(BuilderState state) {
        this.status = state;
    }

    /**
     * @return internal ID of this builder status
     */
    @Override
    public long taskId() {
        return taskId;
    }

    /**
     * @return start time of this builder
     */
    @Override
    public long startTime() {
        return startTime;
    }

    /**
     * @return {@link com.codenvy.client.model.BuilderState} status
     */
    @Override
    public BuilderState status() {
        return status;
    }

    /**
     * @return links of this runner
     */
    @Override
    public List<Link> links() {
        return links;
    }

    /**
     * Gets the build result download {@link com.codenvy.client.model.Link}.
     *
     * @return the download {@link com.codenvy.client.model.Link}.
     */
    @Override
    public Link getDownloadLink() {
        return null;
    }

    /**
     * @return statistics for the runner process on the build part
     */
    @Override
    public List<BuilderMetric> getBuildStats() {
        return builderMetrics;
    }

    public String getLog() {
        return log;
    }

}
