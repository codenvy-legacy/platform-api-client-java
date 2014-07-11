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
package com.codenvy.client.core;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.WorkspaceRef;

/**
 * {@linkplain com.codenvy.client.core.DefaultWorkspaceClient WorkspaceService} tests.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class WorkspaceClientIT extends AbstractIT {
    @Test
    public void testGetAllWorkspaces() {
        final List<? extends Workspace> workspaces = codenvy.workspace()
                                                  .all()
                                                  .execute();

        Assert.assertNotNull(workspaces);
        Assert.assertTrue(workspaces.size() > 0);
        Assert.assertNotNull(workspaces.get(0).workspaceRef());
        Assert.assertNull(workspaces.get(0).workspaceRef().id());
        Assert.assertNotNull(workspaces.get(0).workspaceRef().name());
    }

    @Test(expected = NullPointerException.class)
    public void testGetWorkspaceByNameWithNullName() {
        codenvy.workspace()
               .withName(null)
               .execute();
    }

    @Test
    public void testGetWorkspaceByName() {
        final WorkspaceRef workspaceRef = codenvy.workspace()
                                                 .withName(SDK_WORKSPACE_NAME)
                                                 .execute();

        Assert.assertNotNull(workspaceRef);
        Assert.assertNotNull(workspaceRef.id());
        Assert.assertNotNull(workspaceRef.name());
    }

    @Test(expected = NullPointerException.class)
    public void testNewWorkspaceWithNullWorkspaceRef() {
        codenvy.workspace()
               .create(null)
               .execute();
    }
}
