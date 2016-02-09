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

import com.codenvy.client.model.Workspace;

/**
 * @author Florent Benoit
 */
public class DummyWorkspace implements Workspace {

    private String name;
    private String id;

    public DummyWorkspace(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return ID of this workspace
     */
    @Override
    public String id() {
        return id;
    }

    /**
     * @return name of this workspace reference
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * @return Organization ID
     */
    @Override
    public String organizationId() {
        return null;
    }

    /**
     * @return true if the workspace is a temporary workspace
     */
    @Override
    public boolean isTemporary() {
        return false;
    }
}
