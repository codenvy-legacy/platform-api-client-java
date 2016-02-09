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

import java.util.List;

/**
 * The codenvy builder object model.
 *
 * @author Florent Benoit
 */
public interface BuilderStatus {

    /**
     * @return internal ID of this builder status
     */
    long taskId();

    /**
     * @return start time of this builder
     */
    long startTime();

    /**
     * @return {@link com.codenvy.client.model.BuilderState} status
     */
    BuilderState status();

    /**
     * @return links of this runner
     */
    List<Link> links();

    /**
     * Gets the build result download {@link Link}.
     *
     * @return the download {@link Link}.
     */
    Link getDownloadLink();

    /**
     * @return statistics for the runner process on the build part
     */
    List<BuilderMetric> getBuildStats();

}
