/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.client.dummy.workspace;

import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.WorkspaceReference;

/**
 * @author Florent Benoit
 */
public class DummyWorkspace implements Workspace {

    private DummyWorkspaceReference dummyWorkspaceReference;

    public DummyWorkspace(String name) {
        this.dummyWorkspaceReference = new DummyWorkspaceReference(name);
    }

    public DummyWorkspace(WorkspaceReference workspaceReference) {
        this.dummyWorkspaceReference = new DummyWorkspaceReference(workspaceReference.name());
        //TODO: needs to convert all values
    }


    /**
     * @return workspace reference of this workspace
     */
    @Override
    public DummyWorkspaceReference workspaceReference() {
        return dummyWorkspaceReference;
    }
}
