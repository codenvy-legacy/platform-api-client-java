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
    private final      Map<String, List<String>> attributes;
    private final      String                    defaultRunnerEnvironment;
    private final      String                    defaultBuilderEnvironment;
    private final      String                    runner;
    private final      String                    builder;


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
     * @param runner
     *         the runner.
     * @param builder
     *         the builder.
     * @param defaultBuilderEnvironment
     *         the default builder environment.
     * @param defaultRunnerEnvironment
     *         the default runner environment.
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
            @JsonProperty("ideUrl") String ideUrl,
            @JsonProperty("currentUserPermissions") List<String> userPermissions,
            @JsonProperty("attributes") Map<String, List<String>> attributes,
            @JsonProperty("runner") String runner,
            @JsonProperty("builder") String builder,
            @JsonProperty("defaultBuilderEnvironment") String defaultBuilderEnvironment,
            @JsonProperty("defaultRunnerEnvironment") String defaultRunnerEnvironment
                         ) {
        super(url, visibility, projectTypeId, workspaceId, projectTypeName, name, description, workspaceName, modificationDate,
              creationDate, ideUrl);
        this.userPermissions = userPermissions;
        this.attributes = attributes;
        this.runner = runner;
        this.builder = builder;
        this.defaultBuilderEnvironment = defaultBuilderEnvironment;
        this.defaultRunnerEnvironment = defaultRunnerEnvironment;
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

    /**
     * Returns runner
     *
     * @return the runner
     */
    @JsonProperty("runner")
    @Override
    public String runner() {
        return runner;
    }

    /**
     * Returns builder
     *
     * @return the builder
     */
    @Override
    @JsonProperty("builder")
    public String builder() {
        return builder;
    }

    /**
     * Returns builder environment
     *
     * @return the builder environment
     */
    @Override
    @JsonProperty("defaultBuilderEnvironment")
    public String defaultBuilderEnvironment() {
        return defaultBuilderEnvironment;
    }

    /**
     * Returns runner environment
     *
     * @return the runner environment
     */
    @Override
    @JsonProperty("defaultRunnerEnvironment")
    public String defaultRunnerEnvironment() {
        return defaultRunnerEnvironment;
    }

}
