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
package com.codenvy.client.core;

import com.codenvy.client.CodenvyBuilder;
import com.codenvy.client.CodenvyClient;
import com.codenvy.client.auth.CredentialsBuilder;
import com.codenvy.client.auth.TokenBuilder;
import com.codenvy.client.core.auth.DefaultCredentialsBuilder;
import com.codenvy.client.core.auth.DefaultTokenBuilder;
import com.codenvy.client.core.model.DefaultProjectBuilder;
import com.codenvy.client.core.model.runner.DefaultRunOptionsBuilder;
import com.codenvy.client.model.ProjectBuilder;
import com.codenvy.client.model.runner.RunOptionsBuilder;

/**
 * Default implementation of {@link com.codenvy.client.CodenvyClient} interface.
 *
 * @author Florent Benoit
 */
public class DefaultCodenvyClient implements CodenvyClient {

    /**
     * @return {@link com.codenvy.client.auth.CredentialsBuilder}
     */
    public CredentialsBuilder newCredentialsBuilder() {
        return new DefaultCredentialsBuilder();
    }

    /**
     * Build a new Codenvy builder that will build {@link com.codenvy.client.Codenvy} object connected to Codenvy platform.
     *
     * @param url
     *         the URL to connect to the system
     * @param username
     *         the username to use to the connection
     * @return {@link com.codenvy.client.CodenvyBuilder}
     */
    public CodenvyBuilder newCodenvyBuilder(String url, String username) {
        return new DefaultCodenvyBuilder(url, username);
    }

    /**
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    public ProjectBuilder newProjectBuilder() {
        return new DefaultProjectBuilder();
    }

    /**
     * @param value
     *         the value of the token
     * @return {@link com.codenvy.client.model.ProjectBuilder}
     */
    @Override
    public TokenBuilder newTokenBuilder(String value) {
        return new DefaultTokenBuilder(value);
    }

    /**
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder} instance
     */
    @Override
    public RunOptionsBuilder newRunOptionsBuilder() {
        return new DefaultRunOptionsBuilder();
    }
}
