/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.client.dummy.auth;

import com.codenvy.client.auth.CredentialsBuilder;
import com.codenvy.client.auth.Token;

/**
 * Builder used to build a {@link DummyCredentials} object.
 *
 * @author Florent Benoit
 */
public class DummyCredentialsBuilder implements CredentialsBuilder {
    private String  username;
    private String  password;
    private Token   token;
    private boolean storeOnlyToken;

    /**
     * Defines the user name.
     *
     * @param username
     *         the user name.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
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
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    /**
     * Defines the authentication {@link Token}.
     *
     * @param token
     *         the authentication {@link Token}.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder withToken(Token token) {
        this.token = token;
        return this;
    }

    /**
     * Defines if only the authentication {@link Token} must be stored.
     *
     * @param storeOnlyToken
     *         {@code true} if only the authentication {@link com.codenvy.client.auth.Token} must be stored.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    @Override
    public CredentialsBuilder storeOnlyToken(boolean storeOnlyToken) {
        this.storeOnlyToken = storeOnlyToken;
        return this;
    }

    /**
     * Builds the {@link DummyCredentials} object.
     *
     * @return the created {@link DummyCredentials} object.
     */
    @Override
    public DummyCredentials build() {
        return new DummyCredentials(username, password, token, storeOnlyToken);
    }
}