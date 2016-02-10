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

import java.util.UUID;

/**
 * @author Florent Benoit
 */
public class DummyWorkspaceBuilder {

    private DummyWorkspace dummyWorkspace;


    public DummyWorkspaceBuilder(String name) {
        this.dummyWorkspace = new DummyWorkspace(name);
        this.dummyWorkspace.setId(UUID.randomUUID().toString());

    }


    public DummyWorkspace build() {
        return dummyWorkspace;
    }
}
