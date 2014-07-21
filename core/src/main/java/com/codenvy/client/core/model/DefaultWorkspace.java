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

import static com.google.common.base.Preconditions.checkNotNull;

import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.WorkspaceReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the workspace resource on Codenvy.
 * 
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultWorkspace implements Workspace {

    private final DefaultWorkspaceReference workspaceReference;

    /**
     * Constructs an instance of {@linkplain DefaultWorkspace}.
     *
     * @param workspaceReference the workspace reference.
     * @throws NullPointerException if workspaceRef parameter is {@code null}.
     */
    @JsonCreator
    public DefaultWorkspace(@JsonProperty("workspaceReference") DefaultWorkspaceReference workspaceReference) {
        checkNotNull(workspaceReference);

        this.workspaceReference = workspaceReference;
    }

    @Override
    public WorkspaceReference workspaceReference() {
        return workspaceReference;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + ((workspaceReference == null) ? 0 : workspaceReference.hashCode());
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
        DefaultWorkspace other = (DefaultWorkspace)obj;
        if (workspaceReference == null) {
            if (other.workspaceReference != null)
                return false;
        } else if (!workspaceReference.equals(other.workspaceReference))
            return false;
        return true;
    }

}
