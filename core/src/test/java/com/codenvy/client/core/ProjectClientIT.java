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

import com.codenvy.client.core.model.DefaultProjectBuilder;
import com.codenvy.client.model.Project;
import com.codenvy.client.model.WorkspaceReference;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * {@linkplain com.codenvy.client.core.DefaultProjectClient ProjectService} tests.
 *
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class ProjectClientIT extends AbstractIT {
    private static WorkspaceReference workspace;
    private static Project            projectPrj1;

    @BeforeClass
    public static void initialize() {
        workspace = codenvy.workspace()
                           .withName(SDK_WORKSPACE_NAME)
                           .execute();

        assertNotNull(workspace);

        projectPrj1 = new DefaultProjectBuilder().withProjectTypeId("maven")
                                                 .withName("prj1")
                                                 .withDescription("description")
                                                 .withWorkspaceId(workspace.id())
                                                 .withWorkspaceName(workspace.name())
                                                 .build();

        codenvy.project()
               .create(projectPrj1)
               .execute();

        assertNotNull(projectPrj1);


        final URI uri = UriBuilder.fromUri(REST_API_URL).path("api/project").build();
        final WebTarget webTarget = ClientBuilder.newClient().target(uri);
        webTarget.path(projectPrj1.workspaceId())
                 .path("folder")
                 .path(projectPrj1.name())
                 .path("src")
                 .request()
                 .post(null);

        webTarget.path(projectPrj1.workspaceId())
                 .path("file")
                 .path(projectPrj1.name())
                 .queryParam("name", "src/file.txt")
                 .request()
                 .post(Entity.text(ProjectClientIT.class.getResourceAsStream("/file.txt")));

        webTarget.path(projectPrj1.workspaceId())
                 .path("file")
                 .path(projectPrj1.name())
                 .queryParam("name", "src/file2.txt")
                 .request()
                 .post(Entity.text(ProjectClientIT.class.getResourceAsStream("/file.txt")));
    }

    @Test(expected = NullPointerException.class)
    public void testGetWorkspaceProjectsWithNullWorkspaceId() {
        codenvy.project()
               .getWorkspaceProjects(null)
               .execute();
    }

    @Test
    public void testGetWorkspaceProjects() {
        final List<Project> projects = codenvy.project()
                                              .getWorkspaceProjects(workspace.id())
                                              .execute();

        assertNotNull(projects);
        assertFalse(projects.isEmpty());
        assertTrue(projects.size() == 1);
        Project project = projects.get(0);
        assertNotNull(project);
        assertNotNull("id", project.id());
        assertEquals("prj1", project.name());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateWithNullProject() {
        codenvy.project()
               .create(null)
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testExportResourcesWithNullProject() {
        codenvy.project()
               .exportResources(null, null)
               .execute();
    }

    @Test
    public void testExportResources() {
        final ZipInputStream zipInputStream = codenvy.project()
                                                     .exportResources(projectPrj1, null)
                                                     .execute();

        assertNotNull(zipInputStream);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteResourcesWithNullProject() {
        codenvy.project()
               .deleteResources(null, null)
               .execute();
    }


    @Test(expected = NullPointerException.class)
    public void testImportArchiveWithNullWorkspace() {
        codenvy.project()
               .importArchive(null,
                              projectPrj1,
                              ProjectClientIT.class.getResourceAsStream("/archiveToImport.zip"))
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testImportArchiveWithNullProject() {
        codenvy.project()
               .importArchive(workspace.id(),
                              null,
                              ProjectClientIT.class.getResourceAsStream("/archiveToImport.zip"))
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testImportArchiveWithNullInputStream() {
        codenvy.project()
               .importArchive(workspace.id(),
                              projectPrj1,
                              null)
               .execute();
    }

    @Test
    public void testImportArchive() throws IOException {
        codenvy.project()
               .importArchive(workspace.id(),
                              projectPrj1,
                              ProjectClientIT.class.getResourceAsStream("/archiveToImport.zip"))
               .execute();

        assertTrue(codenvy.project().hasFile(projectPrj1, "/fileToImport.txt").execute());
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateFileWithNullProject() {
        codenvy.project()
               .updateFile(null, "dummyPath", new ByteArrayInputStream(new byte[0]))
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateFileWithNullFilePath() {
        codenvy.project()
               .updateFile(projectPrj1, null, new ByteArrayInputStream(new byte[0]))
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateFileWithNullInputStream() {
        codenvy.project()
               .updateFile(projectPrj1, "dummyPath", null)
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testGetFileWithNullProject() {
        codenvy.project()
               .getFile(null, "dummyPath")
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testGetFileWithNullFilePath() {
        codenvy.project()
               .getFile(projectPrj1, null)
               .execute();
    }

    @Test
    public void testUpdateAndGetFile() throws IOException {
        codenvy.project()
               .updateFile(projectPrj1, "src/file.txt", new ByteArrayInputStream("content2".getBytes()))
               .execute();

        final InputStream stream = codenvy.project()
                                          .getFile(projectPrj1, "src/file.txt")
                                          .execute();

        final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        assertEquals("content2", reader.readLine());
    }

    @Test(expected = NullPointerException.class)
    public void testHasFolderWithNullProject() {
        codenvy.project()
               .hasFolder(null, "dummyPath")
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testHasFileWithNullProject() {
        codenvy.project()
               .hasFile(null, "dummyPath")
               .execute();
    }


    @Test(expected = NullPointerException.class)
    public void testHasFolderWithNullResourcePath() {
        codenvy.project()
               .hasFolder(projectPrj1, null)
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testHasFileWithNullResourcePath() {
        codenvy.project()
               .hasFile(projectPrj1, null)
               .execute();
    }

    @Test
    public void testHasFile() {
        final boolean result = codenvy.project()
                                      .hasFile(projectPrj1, "src/file.txt")
                                      .execute();

        assertTrue(result);
    }

    @Test
    public void testHasFileNotExist() {
        final boolean result = codenvy.project()
                                      .hasFile(projectPrj1, "src/filedoesnotexit.txt")
                                      .execute();

        assertFalse(result);
    }

    @Test
    public void testHasFolder() {
        final boolean result = codenvy.project()
                                      .hasFolder(projectPrj1, "src")
                                      .execute();

        assertTrue(result);
    }

    @Test
    public void testHasFolderNotExist() {
        final boolean result = codenvy.project()
                                      .hasFolder(projectPrj1, "doesnotexist")
                                      .execute();

        assertFalse(result);
    }

    @Test
    public void testDeleteAndIsResources() {
        codenvy.project()
               .deleteResources(projectPrj1, "src/file2.txt")
               .execute();

        final boolean exists = codenvy.project()
                                      .hasFile(projectPrj1, "src/file2.txt")
                                      .execute();

        assertFalse(exists);
    }
}
