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

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;

import com.codenvy.client.model.Project;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the project resource on Codenvy.
 * 
 * @author Kevin Pollet
 */
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultProject implements Project {
    private final String url;
    private final String visibility;
    private final String projectTypeId;
    private final String workspaceId;
    private final String projectTypeName;
    private final String name;
    private final String description;
    private final String workspaceName;
    private final Date   modificationDate;
    private final Date   creationDate;
    private final String ideUrl;

    /**
     * Constructs an instance of {@linkplain DefaultProject}.
     * 
     * @param url the project url.
     * @param visibility the project visibility (private or public).
     * @param projectTypeId the project type id (e.g. spring, java, ...).
     * @param workspaceId the project workspace id.
     * @param projectTypeName the project type name (e.g. Spring application, ...).
     * @param name the project name.
     * @param description the project description.
     * @param workspaceName the project workspace name.
     * @param modificationDate the project modification date.
     * @param creationDate the project creation date.
     * @param ideUrl the project ide url.
     */
    @JsonCreator
    public DefaultProject(
            @JsonProperty("url") String url,
            @JsonProperty("visibility") String visibility,
            @JsonProperty("projectTypeId") String projectTypeId,
            @JsonProperty("workspaceId") String workspaceId,
            @JsonProperty("projectTypeName") String projectTypeName,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("workspaceName") String workspaceName,
            @JsonProperty("modificationDate") Date modificationDate,
            @JsonProperty("creationDate") Date creationDate,
            @JsonProperty("ideUrl") String ideUrl) {

        this.url = url;
        this.visibility = visibility;
        this.projectTypeId = projectTypeId;
        this.workspaceId = workspaceId;
        this.projectTypeName = projectTypeName;
        this.name = name;
        this.description = description;
        this.workspaceName = workspaceName;
        this.modificationDate = modificationDate;
        this.creationDate = creationDate;
        this.ideUrl = ideUrl;
    }

    @JsonProperty("url")
    @Override
    public String url() {
        return url;
    }

    @JsonProperty("visibility")
    @Override
    public String visibility() {
        return visibility;
    }

    @JsonProperty("projectTypeId")
    @Override
    public String projectTypeId() {
        return projectTypeId;
    }

    @JsonProperty("workspaceId")
    @Override
    public String workspaceId() {
        return workspaceId;
    }

    @JsonProperty("projectTypeName")
    @Override
    public String projectTypeName() {
        return projectTypeName;
    }

    @JsonProperty("name")
    @Override
    public String name() {
        return name;
    }

    @JsonProperty("description")
    @Override
    public String description() {
        return description;
    }

    @JsonProperty("workspaceName")
    @Override
    public String workspaceName() {
        return workspaceName;
    }

    @JsonProperty("modificationDate")
    @Override
    public Date modificationDate() {
        return modificationDate;
    }

    @JsonProperty("creationDate")
    @Override
    public Date creationDate() {
        return creationDate;
    }

    @JsonProperty("ideUrl")
    @Override
    public String ideUrl() {
        return ideUrl;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((projectTypeId == null) ? 0 : projectTypeId.hashCode());
        result = prime * result + ((workspaceId == null) ? 0 : workspaceId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultProject other = (DefaultProject)obj;
        if (creationDate == null) {
            if (other.creationDate != null)
                return false;
        } else if (!creationDate.equals(other.creationDate))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (projectTypeId == null) {
            if (other.projectTypeId != null)
                return false;
        } else if (!projectTypeId.equals(other.projectTypeId))
            return false;
        if (workspaceId == null) {
            if (other.workspaceId != null)
                return false;
        } else if (!workspaceId.equals(other.workspaceId))
            return false;
        return true;
    }
}
