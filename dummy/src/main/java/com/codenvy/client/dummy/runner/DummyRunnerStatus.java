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
package com.codenvy.client.dummy.runner;

import com.codenvy.client.model.Link;
import com.codenvy.client.model.RunnerState;
import com.codenvy.client.model.RunnerStatus;
import com.codenvy.client.model.builder.BuilderMetric;
import com.codenvy.client.model.runner.RunnerMetric;

import java.util.List;

/**
 * @author Florent Benoit
 */
public class DummyRunnerStatus implements RunnerStatus {

    private long                processId;
    private long                startTime;
    private RunnerState         state;
    private List<Link>          links;
    private List<BuilderMetric> builderMetrics;
    private String              log;

    public DummyRunnerStatus(long processId) {
        this.processId = processId;
        this.state = RunnerState.NEW;
    }



    /**
     * @return Stop time of this runner
     */
    @Override
    public long stopTime() {
        return 0;
    }

    /**
     * @return debug hostname of this runner
     */
    @Override
    public String debugHost() {
        return null;
    }

    /**
     * @return debug port of this runner
     */
    @Override
    public long debugPort() {
        return 0;
    }

    /**
     * @return internal process ID of this runner
     */
    @Override
    public long processId() {
        return processId;
    }

    /**
     * @return start time of this builder
     */
    @Override
    public long startTime() {
        return startTime;
    }

    /**
     * @return {@link com.codenvy.client.model.RunnerState} state of this runner
     */
    @Override
    public RunnerState status() {
        return state;
    }


    /**
     * @return links of this runner
     */
    @Override
    public List<Link> links() {
        return links;
    }

    /**
     * Returns the web {@link com.codenvy.client.model.Link}.
     *
     * @return the web {@link com.codenvy.client.model.Link} or {@code null}.
     */
    @Override
    public Link getWebLink() {
        return null;
    }

    /**
     * @return statistics for the runner process
     */
    @Override
    public List<RunnerMetric> getRunStats() {
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

    public void setLog(String log) {
        this.log = log;
    }

    public void setStatus(RunnerState state) {
        this.state = state;
    }
}
