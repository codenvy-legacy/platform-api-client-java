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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the configuration for a given runner.
 *
 * @author Florent Benoit
 */
public class DefaultRunnerConfiguration implements RunnerConfiguration {

    private int ram;
    private Map<String, String> options;
    private Map<String, String> variables;

    @JsonCreator
    public DefaultRunnerConfiguration(
            @JsonProperty("ram") int ram,
            @JsonProperty("options") Map<String, String> options,
            @JsonProperty("variables") Map<String, String> variables) {
        this.ram = ram;
        this.options = ImmutableMap.copyOf(options == null ? new HashMap<String, String>() : options);
        this.variables = ImmutableMap.copyOf(variables == null ? new HashMap<String, String>() : variables);
    }

    /**
     * @return amount of RAM for this configuration in megabytes.
     */
    @Override
    @JsonProperty("ram")
    public int ram() {
        return ram;
    }

    /**
     * @return runtime options (runner type and(or) receipt specific).
     */
    @JsonProperty("options")
    @Override
    public Map<String, String> options() {
        return options;
    }

    /**
     * @return environment variables (runner type and(or) receipt specific).
     */
    @Override
    @JsonProperty("variables")
    public Map<String, String> variables() {
        return variables;
    }
}
