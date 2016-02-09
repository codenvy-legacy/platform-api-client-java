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
package com.codenvy.client.dummy.project;

import com.codenvy.client.model.ProjectBuilder;
import com.codenvy.client.model.Workspace;

/**
 * @author Florent Benoit
 */
public class DummyProjectBuilder implements ProjectBuilder {

    private DummyProject dummyProject;


    public DummyProjectBuilder(Workspace workspace, String projectName) {
        this.dummyProject = new DummyProject(workspace, projectName);
    }


    public DummyProjectBuilder() {
        this.dummyProject = new DummyProject();
    }


    /**
     * Specify the url of the project that needs to be created.
     *
     * @param url
     *         the project URL
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withUrl(String url) {
        return this;
    }

    /**
     * Specify the visibility of the project that needs to be created.
     *
     * @param visibility
     *         the project visibility
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withVisibility(String visibility) {
        dummyProject.setVisibility(visibility);
        return this;
    }

    /**
     * Specify the Project ID of the project that needs to be created.
     *
     * @param projectTypeId
     *         the project Type ID
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withType(String projectTypeId) {
        dummyProject.setProjectTypeId(projectTypeId);
        return this;
    }

    /**
     * Specify the workspace ID of the project that needs to be created.
     *
     * @param workspaceId
     *         the project's workspace ID
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withWorkspaceId(String workspaceId) {
        dummyProject.setWorkspaceId(workspaceId);
        return this;
    }

    /**
     * Specify the project Type name of the project that needs to be created.
     *
     * @param projectTypeName
     *         the project type name
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withTypeName(String projectTypeName) {
        return this;
    }

    /**
     * Specify the name of the project that needs to be created.
     *
     * @param name
     *         the project's name
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withName(String name) {
        return this;
    }

    /**
     * Specify the path of the project that needs to be created.
     *
     * @param path
     *         the project's path
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public ProjectBuilder withPath(String path) {
        return this;
    }

    /**
     * Specify the description of the project that needs to be created.
     *
     * @param description
     *         the project's description
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withDescription(String description) {
        return this;
    }

    /**
     * Specify the workspace name of the project that needs to be created.
     *
     * @param workspaceName
     *         the project's workspace name
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withWorkspaceName(String workspaceName) {
        dummyProject.setWorkspaceName(workspaceName);
        return this;
    }

    /**
     * Specify the IDE URL of the project that needs to be created.
     *
     * @param ideUrl
     *         the project's IDE url
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public DummyProjectBuilder withIdeUrl(String ideUrl) {
        return this;
    }

    public DummyProject build() {
        return dummyProject;
    }
}
