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

import com.codenvy.client.model.Project;
import com.codenvy.client.model.ProjectProblem;
import com.codenvy.client.model.ProjectReference;
import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.project.BuildersDescription;
import com.codenvy.client.model.project.RunnersDescription;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Florent Benoit
 */
public class DummyProject implements Project {

    private String name;
    private String workspaceId;
    private String workspaceName;
    private String visibility;
    private String projectTypeId;

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setProjectTypeId(String projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public DummyProject() {
    }


    protected DummyProject(String name, String workspaceId, String workspaceName) {
        this.name = name;
        this.workspaceId = workspaceId;
        this.workspaceName = workspaceName;
    }

    public DummyProject(Workspace workspace, String name) {
        this(name, workspace.id(), workspace.name());
    }

    public DummyProject(ProjectReference projectReference) {
        this(projectReference.name(), projectReference.workspaceId(), projectReference.workspaceName());
        //TODO: needs to convert all values
    }


    /**
     * @return user permissions for this project
     */
    @Override
    public List<String> permissions() {
        return null;
    }

    /**
     * @return the attributes for this given project
     */
    @Override
    public Map<String, List<String>> attributes() {
        return null;
    }

    /**
     * @return the description of the runners
     */
    @Override
    public RunnersDescription runners() {
        return null;
    }

    /**
     * @return the description of the builders
     */
    @Override
    public BuildersDescription builders() {
        return null;
    }

    /**
     * @return URL of the project
     */
    @Override
    public String url() {
        return null;
    }

    /**
     * @return visibility of a project : could be private/public
     */
    @Override
    public String visibility() {
        return visibility;
    }

    /**
     * @return the type ID of the project
     */
    @Override
    public String type() {
        return projectTypeId;
    }

    /**
     * @return the project type name
     */
    @Override
    public String typeName() {
        return null;
    }

    /**
     * @return path of the project
     */
    @Override
    public String path() {
        return null;
    }

    /**
     * @return name of the project
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * @return description of the project
     */
    @Override
    public String description() {
        return null;
    }

    /**
     * @return modification date
     */
    @Override
    public Date modificationDate() {
        return null;
    }

    /**
     * @return creation date
     */
    @Override
    public Date creationDate() {
        return null;
    }

    /**
     * @return IDE URL
     */
    @Override
    public String ideUrl() {
        return null;
    }

    /**
     * @return the name of the workspace
     */
    @Override
    public String workspaceName() {
        return workspaceName;
    }

    /**
     * @return the workspace ID
     */
    @Override
    public String workspaceId() {
        return workspaceId;
    }

    /**
     * @return the problems of the given project
     */
    @Override
    public List<ProjectProblem> getProblems() {
        return null;
    }
}
