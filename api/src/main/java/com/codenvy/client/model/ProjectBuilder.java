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
package com.codenvy.client.model;

/**
 * The Codenvy project builder.
 *
 * @author Kevin Pollet
 */
public interface ProjectBuilder {

    ProjectBuilder withId(String id);

    ProjectBuilder withUrl(String url);

    ProjectBuilder withVisibility(String visibility);

    ProjectBuilder withProjectTypeId(String projectTypeId);

    ProjectBuilder withWorkspaceId(String workspaceId);

    ProjectBuilder withProjectTypeName(String projectTypeName);

    ProjectBuilder withName(String name);

    ProjectBuilder withDescription(String description);

    ProjectBuilder withWorkspaceName(String workspaceName);

    ProjectBuilder withIdeUrl(String ideUrl);

    Project build();
}
