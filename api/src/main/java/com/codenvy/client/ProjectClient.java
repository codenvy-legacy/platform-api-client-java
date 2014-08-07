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

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import com.codenvy.client.model.Project;
import com.codenvy.client.model.Visibility;

/**
 * Client API for dealing with Project REST API.
 * @author Florent Benoit
 */
public interface ProjectClient {
    /**
     * Retrieves all workspace {@link Project}.
     *
     * @param workspaceId the workspace id.
     * @return the workspace {@link Project} list never {@code null}.
     * @throws NullPointerException if workspaceId parameter is {@code null}.
     */
    Request<List<? extends Project>> getWorkspaceProjects(String workspaceId);

    /**
     * Creates a {@link Project} in the given workspace.
     *
     * @param project the {@link Project} to create.
     * @return the new {@link Project}, never {@code null}.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<? extends Project> create(Project project);

    /**
     * Exports a resource in the given {@link Project}.
     *
     * @param project the {@link Project}.
     * @param resourcePath the path of the resource to export, must be a folder.
     * @return the resource {@link java.util.zip.ZipInputStream} or {@code null} if the resource is not found.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<ZipInputStream> exportResources(Project project, String resourcePath);

    /**
     * Deletes a resource in the given {@link Project}.
     *
     * @param project the {@link Project}.
     * @param resourcePath the path of the resource to delete.
     * @return the {@link com.codenvy.client.Request} pointing to a {@link Void} result.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<Void> deleteResources(Project project, String resourcePath);

    /**
     * Upload a local ZIP folder.
     *
     * @param workspaceId the workspace id in which the ZIP folder will be imported.
     * @param project the pre-exisiting {@link Project} in which the archive content should be imported.
     * @param archiveInputStream the archive {@link java.io.InputStream}.
     * @return the {@link com.codenvy.client.Request} pointing to a {@link Void} result.
     * @throws NullPointerException if workspaceId, projectName or archiveInputStrem parameters are {@code null}.
     */
    Request<Void> importArchive(String workspaceId, Project project, InputStream archiveInputStream);

    /**
     * Updates a resource in the given {@link Project}.
     *
     * @param project the {@link Project}.
     * @param filePath the path to the file to update.
     * @param fileInputStream the file {@link java.io.InputStream}.
     * @throws NullPointerException if project, filePath or fileInputStream parameter is {@code null}.
     */
    Request<Void> updateFile(Project project, String filePath, InputStream fileInputStream);

    /**
     * Gets file content in the given {@link Project}.
     *
     * @param project the {@link Project}.
     * @param filePath the file path.
     * @return the file {@link java.io.InputStream} or {@code null} if not found.
     */
    Request<InputStream> getFile(Project project, String filePath);

    /**
     * Returns if the given folder exists in the given {@link Project}.
     *
     * @param project the {@link Project}.
     * @param folderPath the folder path.
     * @return {@code true} if the given resource exists in the Codenvy project, {@code false} otherwise.
     * @throws NullPointerException if project or resourcePath parameter is {@code null}.
     */
    Request<Boolean> hasFolder(Project project, String folderPath);

    /**
     * Returns if the given file exists in the given {@link Project}.
     *
     * @param project the {@link Project}.
     * @param filePath the file path.
     * @return {@code true} if the given resource exists in the Codenvy project, {@code false} otherwise.
     * @throws NullPointerException if project or resourcePath parameter is {@code null}.
     */
    Request<Boolean> hasFile(Project project, String filePath);

    /**
     * Switch visibility for a {@link Project} in the given workspace.
     *
     * @param project the {@link Project} to change visibility.
     * @param visibility the {@link com.codenvy.client.model.Visibility} attribute to change visibility.
     * @throws NullPointerException if project parameter is {@code null}.
     */
    Request<Void> switchVisibility(Project project, Visibility visibility);
}
