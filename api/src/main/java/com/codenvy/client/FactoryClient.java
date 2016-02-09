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

import com.codenvy.client.model.Factory;
import com.codenvy.client.model.ProjectReference;
import com.codenvy.client.model.User;

import java.util.List;

/**
 * The Codenvy Factory API client.
 *
 * @author Florent Benoit
 */
public interface FactoryClient {

    /**
     * Returns factory data
     * @param  jsonContent the content of the JSON factory
     * @return factory information.
     */
    Request<Factory> save(String jsonContent);


    /**
     * Returns factory content of a project
     * @param  {@link ProjectReference} the project to export
     * @return factory content.
     */
    Request<String> export(ProjectReference projectReference);


    /**
     * Deletes a factory based on its id
     * @param factoryId the ID of the factory
     * @return void request
     */
    Request<Void> delete(String factoryId);


    /**
     * Updates a factory by providing its id and JSON content
     * @param factoryId the ID of the factory
     * @param jsonContent the content of the JSON file
     * @return void request
     */
    Request<Void> update(String factoryId, String jsonContent);


    /**
     * List factories ID available
     * @param user the user to use for listing factories
     * @return the list of factories
     */
    Request<List<String>> list(User user);


    /**
     * Gets a factory based on its id
     * @param factoryId the ID of the factory
     * @return factory information
     */
    Request<Factory> get(String factoryId);
}
