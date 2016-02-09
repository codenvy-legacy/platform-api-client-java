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

import com.codenvy.client.Request;
import com.codenvy.client.VFSClient;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.model.vfs.DefaultVFSInfo;
import com.codenvy.client.model.vfs.VfsInfo;

import javax.ws.rs.client.Invocation;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * The Codenvy vfs API client.
 *
 * @author Florent Benoit
 */
public class DefaultVFSClient extends AbstractClient implements VFSClient {

    /**
     * Constructs an instance of {@link VFSClient}.
     *
     * @param url
     *         the Codenvy platform URL.
     * @param authenticationManager
     *         the {@link AuthenticationManager}.
     * @throws NullPointerException
     *         if url or authenticationManager parameter is {@code null}.
     */
    DefaultVFSClient(String url, AuthenticationManager authenticationManager) {
        super(url, "vfs-directory-mapping", authenticationManager);
    }


    /**
     * Sets a VFS folder
     *
     * @param workspaceId
     *         the workspace ID.
     * @param path
     *         the VFS root folder.
     * @return a GIT URL that allow to clone the given project.
     */
    @Override
    public Request<VfsInfo> directoryMapping(String workspaceId, String path) {
        final Invocation request = getWebTarget().path(workspaceId)
                                                 .queryParam("mountPath", path)
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildPost(null);
        return new SimpleRequest<VfsInfo>(request, DefaultVFSInfo.class, getAuthenticationManager());
    }
}
