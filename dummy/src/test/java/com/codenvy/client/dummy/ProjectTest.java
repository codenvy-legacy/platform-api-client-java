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
package com.codenvy.client.dummy;

import com.codenvy.client.WorkspaceClient;
import com.codenvy.client.dummy.project.DummyProject;
import com.codenvy.client.dummy.project.DummyProjectClient;
import com.codenvy.client.model.Project;
import com.codenvy.client.model.ProjectReference;
import com.codenvy.client.model.Workspace;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * @author Florent Benoit
 */
public class ProjectTest {

    private Workspace workspace1;

    private WorkspaceClient workspaceClient;

    private DummyProjectClient projectClient;

    private ProjectReference project1;
    private DummyProject project2;

    @BeforeClass
    public void init() {
        DummyCodenvyClient codenvyClient = new DummyCodenvyClient();
        DummyCodenvy codenvy = codenvyClient.newCodenvyBuilder("url1", "florent").build();
        this.workspaceClient = codenvy.workspace();
        this.projectClient = codenvy.project();

        // Create a workspace
        this.workspace1 = codenvyClient.newWorkspaceBuilder("workspace1").build();

        // build a project with builder with official API
        project1 = codenvyClient.newProjectBuilder().withWorkspaceId(workspace1.id()).withWorkspaceName(workspace1.name()).build();

        // other with our API
        project2 = codenvyClient.newProjectBuilder(workspace1, "project2").build();
    }

    @Test
    public void testNoProjects() {
        // check we don't have any workspaces
        List<ProjectReference> projectReferences = projectClient.getWorkspaceProjects(workspace1.id()).execute();
        assertNotNull(projectReferences);
        assertTrue(projectReferences.isEmpty());
    }

    @Test(dependsOnMethods = "testNoProjects")
    public void createProjects() {

        // Add one project through official API
        Project newProject1 = projectClient.create(project1).execute();
        // check all is OK
        assertNotNull(newProject1);
        assertEquals(newProject1.name(), project1.name());
        assertEquals(newProject1.workspaceId(), project1.workspaceId());
        assertEquals(newProject1.workspaceName(), project1.workspaceName());

        // the other with our API
        projectClient.registerProject(project2);

    }

    @Test(dependsOnMethods = "createProjects")
    public void testGetAllProjects() {
        // check we have it now
        List<ProjectReference> projectReferences = projectClient.getWorkspaceProjects(workspace1.id()).execute();
        assertNotNull(projectReferences);
        assertEquals(projectReferences.size(), 2);
    }

}
