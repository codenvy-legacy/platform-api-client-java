/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 *  [2012] - [2016] Codenvy, S.A.
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.client.core;

import com.codenvy.client.model.Workspace;

import org.junit.Ignore;
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
    @Ignore
    public void testGetAllWorkspaces() {
        final List<Workspace> workspaces = codenvy.workspace()
                                                  .all()
                                                  .execute();

        assertNotNull(workspaces);
        assertEquals(1, workspaces.size());
        Workspace workspace = workspaces.get(0);
        assertNotNull(workspace);
        assertEquals("1q2w3e", workspace.id());
        assertEquals("default", workspace.name());
        assertNotNull(workspaces.get(0).id());
        assertNull(workspace.organizationId());
        assertFalse(workspace.isTemporary());

    }

    @Test(expected = NullPointerException.class)
    @Ignore
    public void testGetWorkspaceByNameWithNullName() {
        codenvy.workspace()
               .withName(null)
               .execute();
    }

    @Test
    @Ignore
    public void testGetWorkspaceByName() {
        final Workspace workspace = codenvy.workspace()
                                                 .withName(SDK_WORKSPACE_NAME)
                                                 .execute();

        assertNotNull(workspace);
        assertNotNull(workspace.id());
        assertNotNull(workspace.name());
        assertFalse(workspace.isTemporary());
    }

    @Test(expected = NullPointerException.class)
    public void testNewWorkspaceWithNullWorkspaceReference() {
        codenvy.workspace()
               .create(null)
               .execute();
    }
}
