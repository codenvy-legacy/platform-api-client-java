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
package com.codenvy.client.core.model;

import com.codenvy.client.model.builder.BuilderMetric;
import com.codenvy.client.model.runner.RunnerMetric;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metric used in Builders and Runners.
 *
 * @author Florent Benoit
 */
public class DefaultMetric implements RunnerMetric, BuilderMetric {

    /**
     * Name of the metric.
     */
    private final String name;

    /**
     * Value of the metric.
     */
    private final String value;

    /**
     * Description of the metric.
     */
    private final String description;

    /**
     * Constructs an instance of both {@link com.codenvy.client.model.runner.RunnerMetric} and {@link
     * com.codenvy.client.model.builder.BuilderMetric}.
     */
    @JsonCreator
    public DefaultMetric(
            @JsonProperty("name") String name,
            @JsonProperty("value") String value,
            @JsonProperty("description") String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
