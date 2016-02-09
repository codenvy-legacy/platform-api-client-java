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
    private String type;
    private String workspaceId;
    private String typeName;
    private String name;
    private String path;
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
    public ProjectBuilder withType(String projectTypeId) {
        this.type = projectTypeId;
        return this;
    }

    @Override
    public ProjectBuilder withWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public ProjectBuilder withTypeName(String projectTypeName) {
        this.typeName = projectTypeName;
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
    public ProjectBuilder withPath(String path) {
        this.path = path;
        return this;
    }

    @Override
    public DefaultProjectReference build() {
        return new DefaultProjectReference(url, visibility, type, workspaceId, typeName, name, path, description,
                                           workspaceName,
                                           null, new Date(), ideUrl, null);
    }
}
