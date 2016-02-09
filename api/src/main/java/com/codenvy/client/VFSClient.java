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
package com.codenvy.client;

import com.codenvy.client.model.vfs.VfsInfo;

/**
 * Client API for dealing with VFS REST API.
 *
 * @author Florent Benoit
 */
public interface VFSClient {

    /**
     * Sets a VFS folder
     *
     * @param workspaceId
     *         the workspace ID.
     * @param path
     *         the VFS root folder.
     * @return a GIT URL that allow to clone the given project.
     */
    Request<VfsInfo> directoryMapping(String workspaceId, String path);


}
