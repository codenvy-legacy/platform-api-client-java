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

import com.codenvy.client.auth.CredentialsBuilder;
import com.codenvy.client.auth.TokenBuilder;
import com.codenvy.client.model.ProjectBuilder;
import com.codenvy.client.model.runner.RunOptionsBuilder;

/**
 * Get builders for creating Codenvy objects.
 *
 * @author Florent Benoit
 */
public interface CodenvyClient {

    /**
     * @return {@link com.codenvy.client.auth.CredentialsBuilder}
     */
    CredentialsBuilder newCredentialsBuilder();

    /**
     * Build a new Codenvy builder that will build {@link Codenvy} object connected to Codenvy platform.
     *
     * @param url
     *         the URL to connect to the system
     * @param username
     *         the username to use to the connection
     * @return {@link com.codenvy.client.CodenvyBuilder}
     */
    CodenvyBuilder newCodenvyBuilder(String url, String username);

    /**
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    ProjectBuilder newProjectBuilder();

    /**
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    TokenBuilder newTokenBuilder(String value);

    /**
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder} instance
     */
    RunOptionsBuilder newRunOptionsBuilder();

}
