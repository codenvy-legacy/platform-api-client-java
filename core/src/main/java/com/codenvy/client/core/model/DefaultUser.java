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
package com.codenvy.client.core.model;

import com.codenvy.client.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This class represents the user resource on Codenvy.
 *
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultUser implements User {
    private final String id;
    private final String password;
    private final String email;

    /**
     * Constructs an instance of {@linkplain DefaultUser}.
     *
     * @param id
     *         the user id.
     * @param password
     *         the user password.
     * @param email
     *         the user email.
     * @throws NullPointerException
     *         if id, password or email parameter is {@code null}.
     */
    @JsonCreator
    public DefaultUser(@JsonProperty("id") String id, @JsonProperty("password") String password, @JsonProperty("email") String email) {
        checkNotNull(id);
        checkNotNull(password);
        checkNotNull(email);

        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String email() {
        return email;
    }

}
