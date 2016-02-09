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
package com.codenvy.client.core.model.project;

import com.codenvy.client.model.project.RunnerConfiguration;
import com.codenvy.client.model.project.RunnersDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Defines default Runner and all runners configuration.
 * @author Florent Benoit
 */
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultRunnersDescription implements RunnersDescription {

    private String defaultRunner;
    private Map<String, RunnerConfiguration> configurations;

    @JsonCreator
    public DefaultRunnersDescription(
            @JsonProperty("default") String defaultRunner,
            @JsonProperty("configs") Map<String, DefaultRunnerConfiguration> configurations) {
        this.defaultRunner = defaultRunner;
        this.configurations = ImmutableMap.copyOf(configurations == null ? new HashMap<String, RunnerConfiguration>() : configurations);
    }

    /**
     * @return the default runner selected (if any)
     */
    @JsonProperty("default")
    @Override
    public String defaultRunner() {
        return defaultRunner;
    }

    /**
     * Gets runner configuration by each configuration name.
     *
     * @return all available runner configurations
     */
    @JsonProperty("configs")
    @Override
    public Map<String, RunnerConfiguration> configurations() {
        return configurations;
    }
}
