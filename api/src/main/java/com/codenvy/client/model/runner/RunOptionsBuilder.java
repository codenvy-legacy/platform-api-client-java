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
package com.codenvy.client.model.runner;

import java.util.List;

/**
 * The Codenvy Runner options builder.
 *
 * @author Florent Benoit
 */
public interface RunOptionsBuilder {

    /**
     * Specify the url of the project that needs to be created.
     *
     * @param memorySize the memory to use for this runner
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder}
     */
    RunOptionsBuilder withMemorySize(int memorySize);

    /**
     * Specify the name of the environment ID to use for this run.
     *
     * @param environmentId the name of the environment ID
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder}
     */
    RunOptionsBuilder withEnvironmentId(String environmentId);

    /**
     * Specify the list of script files to use for this run.
     *
     * @param scriptFiles the list of script files
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder}
     */
    RunOptionsBuilder withScriptFiles(List<String> scriptFiles);

    /**
     * @return instance of {@link com.codenvy.client.model.runner.RunOptions}
     */
    RunOptions build();
}
