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
package com.codenvy.client.dummy.workspace;

import com.codenvy.client.Request;
import com.codenvy.client.WorkspaceClient;
import com.codenvy.client.dummy.DummyRequest;
import com.codenvy.client.model.Workspace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Florent Benoit
 */
public class DummyWorkspaceClient implements WorkspaceClient {

    private Map<String, Workspace> workspaces;

    public DummyWorkspaceClient() {
        this.workspaces = new HashMap<>();
    }


    /**
     * Retrieves all Codenvy workspaces of the user identified by the authentication token.
     *
     * @return all Codenvy workspaces never {@code null}.
     */
    @Override
    public Request<List<Workspace>> all() {

        List<Workspace> workspacesToReturn = new ArrayList<>();
        for (Workspace dummyWorkspace : workspaces.values()) {
            workspacesToReturn.add(dummyWorkspace);
        }

        return new DummyRequest<>(workspacesToReturn);
    }

    /**
     * Retrieves a Codenvy workspace by it's name.
     *
     * @param name
     *         the workspace name.
     * @return the Codenvy workspace or {@code null} if none.
     * @throws NullPointerException
     *         if name parameter is {@code null}.
     */
    @Override
    public Request<Workspace> withName(String name) {
        for (Map.Entry<String, Workspace> entry : workspaces.entrySet()) {
            if (name.equals(entry.getKey())) {
                return new DummyRequest<Workspace>(entry.getValue());
            }
        }
        return new DummyRequest<>(null);
    }

    /**
     * Creates the given workspace.
     *
     * @param workspace
     *         the workspace to create.
     * @return the created workspace.
     * @throws NullPointerException
     *         if {@link com.codenvy.client.model.Workspace} parameter is {@code null}.
     */
    @Override
    public Request<Workspace> create(Workspace workspace) {
        registerWorkspace(workspace);
        return new DummyRequest<Workspace>(workspace);
    }


    public void registerWorkspace(Workspace workspace) {
        workspaces.put(workspace.name(), workspace);
    }
}
