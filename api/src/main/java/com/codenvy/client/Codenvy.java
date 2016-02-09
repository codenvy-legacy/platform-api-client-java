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

/**
 * The Codenvy API client.
 *
 * @author Florent Benoit
 */
public interface Codenvy {

    /**
     * Returns the user API client.
     *
     * @return the user API client.
     */
    UserClient user();

    /**
     * Returns the builder API client.
     *
     * @return the builder API client.
     */

    BuilderClient builder();

    /**
     * Returns the runner API client.
     *
     * @return the runner API client.
     */
    RunnerClient runner();

    /**
     * Returns the project API client.
     *
     * @return the project API client.
     */
    ProjectClient project();

    /**
     * Returns the workspace API client.
     *
     * @return the workspace API client.
     */
    WorkspaceClient workspace();

    /**
     * Returns the version API client.
     *
     * @return the version API client.
     */
    VersionClient version();

    /**
     * Returns the factory API client.
     *
     * @return the factory API client.
     */
    FactoryClient factory();

    /**
     * Returns the Git API client.
     *
     * @return the Git API client.
     */
    GitClient git();

    /**
     * Returns the factory API client.
     *
     * @return the factory API client.
     */
    VFSClient vfs();

}
