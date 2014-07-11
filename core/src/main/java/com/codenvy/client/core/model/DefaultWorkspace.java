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
import com.codenvy.client.model.WorkspaceRef;
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

    private final DefaultWorkspaceRef workspaceRef;

    /**
     * Constructs an instance of {@linkplain DefaultWorkspace}.
     *
     * @param workspaceRef the workspace reference.
     * @throws NullPointerException if workspaceRef parameter is {@code null}.
     */
    @JsonCreator
    public DefaultWorkspace(@JsonProperty("workspaceRef") DefaultWorkspaceRef workspaceRef) {
        checkNotNull(workspaceRef);

        this.workspaceRef = workspaceRef;
    }

    @Override
    public WorkspaceRef workspaceRef() {
        return workspaceRef;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + ((workspaceRef == null) ? 0 : workspaceRef.hashCode());
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
        if (workspaceRef == null) {
            if (other.workspaceRef != null)
                return false;
        } else if (!workspaceRef.equals(other.workspaceRef))
            return false;
        return true;
    }

}
