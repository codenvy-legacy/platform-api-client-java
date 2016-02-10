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

import com.codenvy.client.model.project.BuildersDescription;
import com.codenvy.client.model.project.RunnersDescription;

import java.util.List;
import java.util.Map;

/**
 * Project description is containing the data of a project
 *
 * @author Florent Benoit
 */
public interface Project extends ProjectReference {

    /**
     * @return user permissions for this project
     */
    List<String> permissions();

    /**
     * @return the attributes for this given project
     */
    Map<String, List<String>> attributes();


    /**
     * @return the description of the runners
     */
    RunnersDescription runners();

    /**
     * @return the description of the builders
     */
    BuildersDescription builders();

}
