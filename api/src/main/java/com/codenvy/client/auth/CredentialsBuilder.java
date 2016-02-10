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
package com.codenvy.client.auth;

/**
 * Builder used to build a {@link Credentials} object.
 *
 * @author Florent Benoit
 */
public interface CredentialsBuilder {

    /**
     * Defines the user name.
     *
     * @param username
     *         the user name.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    CredentialsBuilder withUsername(String username);

    /**
     * Defines the user password.
     *
     * @param password
     *         the user password.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    CredentialsBuilder withPassword(String password);

    /**
     * Defines the authentication {@link com.codenvy.client.auth.Token}.
     *
     * @param token
     *         the authentication {@link com.codenvy.client.auth.Token}.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    CredentialsBuilder withToken(Token token);

    /**
     * Defines if only the authentication {@link Token} must be stored.
     *
     * @param storeOnlyToken
     *         {@code true} if only the authentication {@link com.codenvy.client.auth.Token} must be stored.
     * @return the {@link com.codenvy.client.auth.CredentialsBuilder} instance.
     */
    CredentialsBuilder storeOnlyToken(boolean storeOnlyToken);

    /**
     * Builds the {@link com.codenvy.client.auth.Credentials} object.
     *
     * @return the created {@link com.codenvy.client.auth.Credentials} object.
     */
    Credentials build();
}
