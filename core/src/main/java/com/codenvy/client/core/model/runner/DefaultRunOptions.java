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
package com.codenvy.client.core.model.runner;

import com.codenvy.client.model.runner.RunOptions;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Florent Benoit
 */
public class DefaultRunOptions implements RunOptions {

    /**
     * Memory size.
     */
    private int memorySize;

    /**
     * Specify the name of the environment ID to use for this run.
     */
    private String environmentId;

    /**
     * Specify the list of script files to use for this run.
     */
    private List<String> scriptFiles;

    /**
     * @return in MB the size of the memory to use for this runner
     */
    @Override
    @JsonProperty("memorySize")
    public int getMemorySize() {
        return memorySize;
    }

    /**
     * @return id of environment that should be used for running an application.
     */
    @Override
    @JsonProperty("environmentId")
    public String getEnvironmentId() {
        return environmentId;
    }

    /**
     * @return recipes for the runner
     */
    @JsonProperty("scriptFiles")
    @Override
    public List<String> getScriptFiles() {
        return scriptFiles;
    }

    /**
     * Specify the url of the project that needs to be created.
     *
     * @param memorySize
     *         the memory to use for this runner
     * @return {@link com.codenvy.client.core.model.runner.DefaultRunOptions}
     */
    public DefaultRunOptions withMemorySize(int memorySize) {
        this.memorySize = memorySize;
        return this;
    }

    /**
     * Specify the name of the environment ID to use for this run.
     *
     * @param environmentId
     *         the name of the environment ID
     * @return {@link com.codenvy.client.core.model.runner.DefaultRunOptions}
     */
    public DefaultRunOptions withEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
        return this;
    }

    /**
     * Specify the list of script files to use for this run.
     *
     * @param scriptFiles
     *         the list of script files
     * @return {@link com.codenvy.client.core.model.runner.DefaultRunOptions}
     */
    public DefaultRunOptions withScriptFiles(List<String> scriptFiles) {
        this.scriptFiles = scriptFiles;
        return this;
    }
}
