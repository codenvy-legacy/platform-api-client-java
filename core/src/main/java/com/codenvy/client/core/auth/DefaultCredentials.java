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
package com.codenvy.client.core.auth;

import com.codenvy.client.auth.Credentials;
import com.codenvy.client.auth.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User credentials used for authentication.
 * 
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = "token")
public class DefaultCredentials implements Credentials {
    private String       username;
    private String       password;
    private Token token;
    private boolean      storeOnlyToken;

    /**
     * Constructs an instance of {@link DefaultCredentials}.
     *
     * @param username the user name.
     * @param password the user password.
     * @param token the user authentication {@link Token}.
     * @param storeOnlyToken {@code true} if only the authentication {@link Token} must be stored.
     */
    protected DefaultCredentials(String username, String password, Token token, boolean storeOnlyToken) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.storeOnlyToken = storeOnlyToken;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DefaultCredentials other = (DefaultCredentials)obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }


    @JsonProperty("username")
    @Override
    public String username() {
        return username;
    }

    @JsonProperty("username")
    public Credentials withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonProperty("password")
    @Override
    public String password() {
        return password;
    }

    @JsonProperty("password")
    public Credentials withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public Token token() {
        return token;
    }

    public Credentials withToken(Token token) {
        this.token = token;
        return this;
    }

    @Override
    public boolean isStoreOnlyToken() {
        return storeOnlyToken;
    }

    public Credentials withStoreOnlyToken(boolean storeOnlyToken) {
        this.storeOnlyToken = storeOnlyToken;
        return this;
    }
}
