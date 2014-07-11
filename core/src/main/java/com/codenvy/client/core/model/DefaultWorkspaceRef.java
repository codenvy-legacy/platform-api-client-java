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
import static com.google.common.base.Preconditions.checkNotNull;

import com.codenvy.client.model.WorkspaceRef;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the workspace reference resource on Codenvy.
 *
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class DefaultWorkspaceRef implements WorkspaceRef {
    private final String id;
    private final String name;
    private final String organizationId;

    /**
     * Constructs an instance of {@linkplain WorkspaceRef}.
     *
     * @param id the workspace reference id.
     * @param name the workspace reference name.
     * @param organizationId the workspace organization.
     * @throws NullPointerException if name parameter is {@code null}.
     */
    @JsonCreator
    public DefaultWorkspaceRef(@JsonProperty("id") String id, @JsonProperty("name") String name,
                               @JsonProperty("organizationId") String organizationId) {
        checkNotNull(name);

        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
    }


    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String organizationId() {
        return organizationId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((organizationId == null) ? 0 : organizationId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        DefaultWorkspaceRef other = (DefaultWorkspaceRef)obj;
        if (organizationId == null) {
            if (other.organizationId != null)
                return false;
        } else if (!organizationId.equals(other.organizationId))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
