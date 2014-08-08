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
import com.codenvy.client.model.ProjectReference;
import com.codenvy.client.model.WorkspaceReference;

import org.junit.Assert;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
    private static ProjectReference   projectReferencePrj1;

    @BeforeClass
    public static void initialize() {
        workspace = codenvy.workspace()
                           .withName(SDK_WORKSPACE_NAME)
                           .execute();

        assertNotNull(workspace);

        projectReferencePrj1 = new DefaultProjectBuilder().withProjectTypeId("maven")
                                                          .withName("prj1")
                                                          .withDescription("description")
                                                          .withWorkspaceId(workspace.id())
                                                          .withWorkspaceName(workspace.name())
                                                          .build();

        codenvy.project()
               .create(projectReferencePrj1)
               .execute();

        assertNotNull(projectReferencePrj1);


        final URI uri = UriBuilder.fromUri(REST_API_URL).path("api/project").build();
        final WebTarget webTarget = ClientBuilder.newClient().target(uri);
        webTarget.path(projectReferencePrj1.workspaceId())
                 .path("folder")
                 .path(projectReferencePrj1.name())
                 .path("src")
                 .request()
                 .post(null);

        webTarget.path(projectReferencePrj1.workspaceId())
                 .path("file")
                 .path(projectReferencePrj1.name())
                 .queryParam("name", "src/file.txt")
                 .request()
                 .post(Entity.text(ProjectClientIT.class.getResourceAsStream("/file.txt")));

        webTarget.path(projectReferencePrj1.workspaceId())
                 .path("file")
                 .path(projectReferencePrj1.name())
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
        final List<ProjectReference> projectReferences = codenvy.project()
                                              .getWorkspaceProjects(workspace.id())
                                              .execute();

        assertNotNull(projectReferences);
        assertFalse(projectReferences.isEmpty());
        assertTrue(projectReferences.size() == 1);
        ProjectReference projectReference = projectReferences.get(0);
        assertNotNull(projectReference);
        assertNotNull("id", projectReference.id());
        assertEquals("prj1", projectReference.name());
    }

    @Test
    public void testGetWorkspaceProject() {
        final Project project = codenvy.project()
                                                                .getProject(workspace.id(), "prj1")
                                                                .execute();
        assertNotNull(project);
        assertEquals("prj1", project.name());
    }

    @Test
    public void testGetWorkspaceProjectPermissions() {
        final Project project = codenvy.project()
                                       .getProject(workspace.id(), "prj1")
                                       .execute();
        assertNotNull(project);
        List<String> permissions = project.userPermissions();
        // Check we've the permissions
        assertNotNull(permissions);
        Collection<String> expected = Arrays.asList("read", "write", "update_acl", "build", "run");

        assertTrue(permissions.containsAll(expected));
    }

    @Test
    public void testGetWorkspaceProjectAttributes() {
        final Project project = codenvy.project()
                                       .getProject(workspace.id(), "prj1")
                                       .execute();
        assertNotNull(project);
        Map<String, List<String>> attributes = project.attributes();
        // Check we've the attributes
        assertNotNull(attributes);

        assertTrue(attributes.containsKey("language"));
        assertTrue(attributes.containsKey("builder.name"));

        // builder name
        List<String> builders = attributes.get("builder.name");
        assertEquals(1, builders.size());
        assertEquals("maven", builders.get(0));

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
                                                     .exportResources(projectReferencePrj1, null)
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
                              projectReferencePrj1,
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
                              projectReferencePrj1,
                              null)
               .execute();
    }

    @Test
    public void testImportArchive() throws IOException {
        codenvy.project()
               .importArchive(workspace.id(),
                              projectReferencePrj1,
                              ProjectClientIT.class.getResourceAsStream("/archiveToImport.zip"))
               .execute();

        assertTrue(codenvy.project().hasFile(projectReferencePrj1, "/fileToImport.txt").execute());
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
               .updateFile(projectReferencePrj1, null, new ByteArrayInputStream(new byte[0]))
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateFileWithNullInputStream() {
        codenvy.project()
               .updateFile(projectReferencePrj1, "dummyPath", null)
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
               .getFile(projectReferencePrj1, null)
               .execute();
    }

    @Test
    public void testUpdateAndGetFile() throws IOException {
        codenvy.project()
               .updateFile(projectReferencePrj1, "src/file.txt", new ByteArrayInputStream("content2".getBytes()))
               .execute();

        final InputStream stream = codenvy.project()
                                          .getFile(projectReferencePrj1, "src/file.txt")
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
               .hasFolder(projectReferencePrj1, null)
               .execute();
    }

    @Test(expected = NullPointerException.class)
    public void testHasFileWithNullResourcePath() {
        codenvy.project()
               .hasFile(projectReferencePrj1, null)
               .execute();
    }

    @Test
    public void testHasFile() {
        final boolean result = codenvy.project()
                                      .hasFile(projectReferencePrj1, "src/file.txt")
                                      .execute();

        assertTrue(result);
    }

    @Test
    public void testHasFileNotExist() {
        final boolean result = codenvy.project()
                                      .hasFile(projectReferencePrj1, "src/filedoesnotexit.txt")
                                      .execute();

        assertFalse(result);
    }

    @Test
    public void testHasFolder() {
        final boolean result = codenvy.project()
                                      .hasFolder(projectReferencePrj1, "src")
                                      .execute();

        assertTrue(result);
    }

    @Test
    public void testHasFolderNotExist() {
        final boolean result = codenvy.project()
                                      .hasFolder(projectReferencePrj1, "doesnotexist")
                                      .execute();

        assertFalse(result);
    }

    @Test
    public void testDeleteAndIsResources() {
        codenvy.project()
               .deleteResources(projectReferencePrj1, "src/file2.txt")
               .execute();

        final boolean exists = codenvy.project()
                                      .hasFile(projectReferencePrj1, "src/file2.txt")
                                      .execute();

        assertFalse(exists);
    }
}
