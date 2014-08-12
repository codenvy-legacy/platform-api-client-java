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

package com.codenvy.client.dummy.workspace;

import com.codenvy.client.model.WorkspaceReference;

/**
 * @author Florent Benoit
 */
public class DummyWorkspaceReference implements WorkspaceReference {

    private String name;
    private String id;

    public DummyWorkspaceReference(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return ID of this workspace
     */
    @Override
    public String id() {
        return id;
    }

    /**
     * @return name of this workspace reference
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * @return Organization ID
     */
    @Override
    public String organizationId() {
        return null;
    }

    /**
     * @return true if the workspace is a temporary workspace
     */
    @Override
    public boolean isTemporary() {
        return false;
    }
}
