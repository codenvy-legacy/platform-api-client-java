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

import java.util.Date;

/**
 * This class represents the project resource on Codenvy.
 *
 * @author Florent Benoit
 */
public interface ProjectReference {
    /**
     * @return project ID
     */
    String id();

    /**
     * @return URL of the project
     */
    String url();

    /**
     * @return visibility of a project : could be private/public
     */
    String visibility();

    /**
     * @return the type ID of the project
     */
    String projectTypeId();

    /**
     * @return the project type name
     */
    String projectTypeName();

    /**
     * @return name of the project
     */
    String name();

    /**
     * @return description of the project
     */
    String description();

    /**
     * @return modification date
     */
    Date modificationDate();

    /**
     * @return creation date
     */
    Date creationDate();

    /**
     * @return IDE URL
     */
    String ideUrl();

    /**
     * @return the name of the workspace
     */
    String workspaceName();

    /**
     * @return the workspace ID
     */
    String workspaceId();

}