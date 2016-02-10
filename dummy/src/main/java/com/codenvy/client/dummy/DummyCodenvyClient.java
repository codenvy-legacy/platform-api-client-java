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
package com.codenvy.client.dummy;

import com.codenvy.client.CodenvyClient;
import com.codenvy.client.auth.CredentialsBuilder;
import com.codenvy.client.auth.TokenBuilder;
import com.codenvy.client.dummy.auth.DummyCredentialsBuilder;
import com.codenvy.client.dummy.auth.DummyTokenBuilder;
import com.codenvy.client.dummy.builder.DummyBuilderStatusBuilder;
import com.codenvy.client.dummy.project.DummyProjectBuilder;
import com.codenvy.client.dummy.runner.DummyRunnerStatusBuilder;
import com.codenvy.client.dummy.workspace.DummyWorkspaceBuilder;
import com.codenvy.client.model.ProjectBuilder;
import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.runner.RunOptionsBuilder;

/**
 * @author Florent Benoit
 */
public class DummyCodenvyClient implements CodenvyClient {

    /**
     * @return {@link com.codenvy.client.auth.CredentialsBuilder}
     */
    @Override
    public CredentialsBuilder newCredentialsBuilder() {
        return new DummyCredentialsBuilder();
    }


    /**
     * Build a new Codenvy builder that will build {@link com.codenvy.client.Codenvy} object connected to Codenvy platform.
     *
     * @param url
     *         the URL to connect to the system
     * @param username
     *         the username to use to the connection
     * @return {@link com.codenvy.client.CodenvyBuilder}
     */
    @Override
    public DummyCodenvyBuilder newCodenvyBuilder(String url, String username) {
        return new DummyCodenvyBuilder(url, username);
    }

    /**
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public ProjectBuilder newProjectBuilder() {
        return new DummyProjectBuilder();
    }

    /**
     * @param value
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public TokenBuilder newTokenBuilder(String value) {
        return new DummyTokenBuilder(value);
    }

    /**
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder} instance
     */
    @Override
    public RunOptionsBuilder newRunOptionsBuilder() {
        return null;
    }

    public DummyBuilderStatusBuilder newDummyBuilderStatus(Long taskId) {
        return new DummyBuilderStatusBuilder(taskId);
    }

    public DummyRunnerStatusBuilder newDummyRunnerStatus(Long processId) {
        return new DummyRunnerStatusBuilder(processId);
    }

    public DummyWorkspaceBuilder newWorkspaceBuilder(String name) {
        return new DummyWorkspaceBuilder(name);
    }

    public DummyProjectBuilder newProjectBuilder(Workspace workspace, String projectName) {
        return new DummyProjectBuilder(workspace, projectName);
    }


}
