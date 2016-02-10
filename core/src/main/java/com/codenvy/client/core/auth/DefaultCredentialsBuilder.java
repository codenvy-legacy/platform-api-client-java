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
package com.codenvy.client.core.auth;

import com.codenvy.client.auth.CredentialsBuilder;
import com.codenvy.client.auth.Token;

/**
 * Builder used to build a {@link DefaultCredentials} object.
 *
 * @author Kevin Pollet
 */
public class DefaultCredentialsBuilder implements CredentialsBuilder {
    private String  username;
    private String  password;
    private Token   token;
    private boolean storeOnlyToken;

    /**
     * Defines the user name.
     *
     * @param username
     *         the user name.
     * @return the {@link CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * Defines the user password.
     *
     * @param password
     *         the user password.
     * @return the {@link CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Defines the authentication {@link DefaultToken}.
     *
     * @param token
     *         the authentication {@link DefaultToken}.
     * @return the {@link CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder withToken(Token token) {
        this.token = token;
        return this;
    }

    /**
     * Defines if only the authentication {@link DefaultToken} must be stored.
     *
     * @param storeOnlyToken
     *         {@code true} if only the authentication {@link DefaultToken} must be stored.
     * @return the {@link CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder storeOnlyToken(boolean storeOnlyToken) {
        this.storeOnlyToken = storeOnlyToken;
        return this;
    }

    /**
     * Builds the {@link DefaultCredentials} object.
     *
     * @return the created {@link DefaultCredentials} object.
     */
    @Override
    public DefaultCredentials build() {
        return new DefaultCredentials(username, password, token, storeOnlyToken);
    }
}