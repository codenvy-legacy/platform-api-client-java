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
import com.codenvy.client.model.runner.RunOptionsBuilder;

import java.util.List;

/**
 * Builder allowing to create and configure a {@link com.codenvy.client.model.runner.RunOptions} instance
 * @author Florent Benoit
 */
public class DefaultRunOptionsBuilder implements RunOptionsBuilder {

    /**
     * Define memory to use.
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
     * Specify the url of the project that needs to be created.
     *
     * @param memorySize
     *         the memory to use for this runner
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder}
     */
    @Override
    public RunOptionsBuilder withMemorySize(int memorySize) {
        this.memorySize = memorySize;
        return this;
    }

    /**
     * Specify the name of the environment ID to use for this run.
     *
     * @param environmentId
     *         the name of the environment ID
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder}
     */
    @Override
    public RunOptionsBuilder withEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
        return this;
    }

    /**
     * Specify the list of script files to use for this run.
     *
     * @param scriptFiles
     *         the list of script files
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder}
     */
    @Override
    public RunOptionsBuilder withScriptFiles(List<String> scriptFiles) {
        this.scriptFiles = scriptFiles;
        return this;
    }

    /**
     * @return instance of {@link com.codenvy.client.model.runner.RunOptions}
     */
    @Override
    public RunOptions build() {
        return new DefaultRunOptions().withMemorySize(memorySize).withScriptFiles(scriptFiles).withEnvironmentId(environmentId);
    }
}
