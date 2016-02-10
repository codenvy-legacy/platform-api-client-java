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
package com.codenvy.client.model;

import java.util.Date;
import java.util.List;

/**
 * This class represents the project resource on Codenvy.
 *
 * @author Florent Benoit
 */
public interface ProjectReference {

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
    String type();

    /**
     * @return the project type name
     */
    String typeName();

    /**
     * @return path of the project
     */
    String path();

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

    /**
     *
     * @return the problems of the given project
     */
    List<ProjectProblem> getProblems();

}
