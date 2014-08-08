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

import com.codenvy.client.model.Workspace;
import com.codenvy.client.model.WorkspaceReference;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * {@linkplain com.codenvy.client.core.DefaultWorkspaceClient WorkspaceService} tests.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class WorkspaceClientIT extends AbstractIT {
    @Test
    public void testGetAllWorkspaces() {
        final List<Workspace> workspaces = codenvy.workspace()
                                                  .all()
                                                  .execute();

        assertNotNull(workspaces);
        assertEquals(1, workspaces.size());
        WorkspaceReference workspaceReference = workspaces.get(0).workspaceReference();
        assertNotNull(workspaceReference);
        assertEquals("1q2w3e", workspaceReference.id());
        assertEquals("default", workspaceReference.name());
        assertNotNull(workspaces.get(0).workspaceReference().id());
        assertNull(workspaceReference.organizationId());
        assertFalse(workspaceReference.isTemporary());

    }

    @Test(expected = NullPointerException.class)
    public void testGetWorkspaceByNameWithNullName() {
        codenvy.workspace()
               .withName(null)
               .execute();
    }

    @Test
    public void testGetWorkspaceByName() {
        final WorkspaceReference workspaceReference = codenvy.workspace()
                                                 .withName(SDK_WORKSPACE_NAME)
                                                 .execute();

        assertNotNull(workspaceReference);
        assertNotNull(workspaceReference.id());
        assertNotNull(workspaceReference.name());
        assertFalse(workspaceReference.isTemporary());
    }

    @Test(expected = NullPointerException.class)
    public void testNewWorkspaceWithNullWorkspaceReference() {
        codenvy.workspace()
               .create(null)
               .execute();
    }
}
