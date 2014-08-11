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

import com.codenvy.client.model.Project;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * This class represents the project resource on Codenvy.
 *
 * @author Kevin Pollet
 */
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultProject extends DefaultProjectReference implements Project {

    private final List<String>              userPermissions;
    private       Map<String, List<String>> attributes;


    /**
     * Constructs an instance of {@linkplain com.codenvy.client.core.model.DefaultProject}.
     *
     * @param url
     *         the project url.
     * @param visibility
     *         the project visibility (private or public).
     * @param projectTypeId
     *         the project type id (e.g. spring, java, ...).
     * @param workspaceId
     *         the project workspace id.
     * @param projectTypeName
     *         the project type name (e.g. Spring application, ...).
     * @param name
     *         the project name.
     * @param description
     *         the project description.
     * @param workspaceName
     *         the project workspace name.
     * @param modificationDate
     *         the project modification date.
     * @param creationDate
     *         the project creation date.
     * @param ideUrl
     *         the project ide url.
     */
    @JsonCreator
    public DefaultProject(
            @JsonProperty("id") String id,
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
            @JsonProperty("ideUrl") String ideUrl,
            @JsonProperty("currentUserPermissions") List<String> userPermissions,
            @JsonProperty("attributes") Map<String, List<String>> attributes
                         ) {
        super(id, url, visibility, projectTypeId, workspaceId, projectTypeName, name, description, workspaceName, modificationDate,
              creationDate, ideUrl);
        this.userPermissions = userPermissions;
        this.attributes = attributes;
    }

    @JsonProperty("currentUserPermissions")
    @Override
    public List<String> userPermissions() {
        return userPermissions;
    }

    @JsonProperty("attributes")
    @Override
    public Map<String, List<String>> attributes() {
        return attributes;
    }

}
