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
package com.codenvy.client.core.model;

import com.codenvy.client.model.ProjectBuilder;

import java.util.Date;

/**
 * The Codenvy project builder.
 *
 * @author Kevin Pollet
 */
public class DefaultProjectBuilder implements ProjectBuilder {
    private String url;
    private String visibility;
    private String projectTypeId;
    private String workspaceId;
    private String projectTypeName;
    private String name;
    private String description;
    private String workspaceName;
    private String ideUrl;


    @Override
    public ProjectBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public ProjectBuilder withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    @Override
    public ProjectBuilder withProjectTypeId(String projectTypeId) {
        this.projectTypeId = projectTypeId;
        return this;
    }

    @Override
    public ProjectBuilder withWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public ProjectBuilder withProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
        return this;
    }

    @Override
    public ProjectBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProjectBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProjectBuilder withWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
        return this;
    }

    @Override
    public ProjectBuilder withIdeUrl(String ideUrl) {
        this.ideUrl = ideUrl;
        return this;
    }

    @Override
    public DefaultProjectReference build() {
        return new DefaultProjectReference(url, visibility, projectTypeId, workspaceId, projectTypeName, name, description,
                                           workspaceName,
                                           null, new Date(), ideUrl);
    }
}
