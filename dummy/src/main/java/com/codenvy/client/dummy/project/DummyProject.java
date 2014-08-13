/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/

package com.codenvy.client.dummy.project;

import com.codenvy.client.model.Project;
import com.codenvy.client.model.ProjectReference;
import com.codenvy.client.model.WorkspaceReference;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    public DummyProject(WorkspaceReference workspaceReference, String name) {
        this(name, workspaceReference.id(), workspaceReference.name());
    }

    public DummyProject(ProjectReference projectReference) {
        this(projectReference.name(), projectReference.workspaceId(), projectReference.workspaceName());
        //TODO: needs to convert all values
    }


    /**
     * @return user permissions for this project
     */
    @Override
    public List<String> userPermissions() {
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
    public String projectTypeId() {
        return projectTypeId;
    }

    /**
     * @return the project type name
     */
    @Override
    public String projectTypeName() {
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
}
