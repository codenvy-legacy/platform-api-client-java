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
package com.codenvy.client.model;

import com.codenvy.client.model.builder.BuilderMetric;
import com.codenvy.client.model.runner.RunnerMetric;

import java.util.List;

/**
 * The codenvy runner object model.
 *
 * @author Florent Benoit
 */
public interface RunnerStatus {

    /**
     * @return Stop time of this runner
     */
    long stopTime();

    /**
     * @return debug hostname of this runner
     */
    String debugHost();

    /**
     * @return debug port of this runner
     */
    long debugPort();

    /**
     * @return internal process ID of this runner
     */
    long processId();

    /**
     * @return Start time of this runner
     */
    long startTime();

    /**
     * @return {@link com.codenvy.client.model.RunnerState} state of this runner
     */
    RunnerState status();

    /**
     * @return links of this runner
     */
    List<Link> links();

    /**
     * Returns the web {@link Link}.
     *
     * @return the web {@link Link} or {@code null}.
     */
    Link getWebLink();

    /**
     * @return statistics for the runner process
     */
    List<RunnerMetric> getRunStats();

    /**
     * @return statistics for the runner process on the build part
     */
    List<BuilderMetric> getBuildStats();

}
