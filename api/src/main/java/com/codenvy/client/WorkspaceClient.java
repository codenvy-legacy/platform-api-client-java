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
package com.codenvy.client;


import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.WorkspaceRef;

import java.util.List;

/**
 *  The Codenvy workspace API client.
 * @author Florent Benoit
 */
public interface WorkspaceClient {
    /**
     * Retrieves all Codenvy workspaces of the user identified by the authentication token.
     *
     * @return all Codenvy workspaces never {@code null}.
     */
    Request<List<? extends Workspace>> all();

    /**
     * Retrieves a Codenvy workspace by it's name.
     *
     * @param name the workspace name.
     * @return the Codenvy workspace or {@code null} if none.
     * @throws NullPointerException if name parameter is {@code null}.
     */
    Request<? extends WorkspaceRef> withName(String name);

    /**
     * Creates the given workspace.
     *
     * @param workspaceRef the workspace to create.
     * @return the created workspace.
     * @throws NullPointerException if {@link WorkspaceRef} parameter is {@code null}.
     */
    Request<? extends WorkspaceRef> create(WorkspaceRef workspaceRef);
}
