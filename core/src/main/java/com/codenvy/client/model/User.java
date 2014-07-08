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
package com.codenvy.client.model;

import static com.google.common.base.Preconditions.checkNotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the user resource on Codenvy.
 * 
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public final String id;
    public final String password;
    public final String email;

    /**
     * Constructs an instance of {@linkplain User}.
     * 
     * @param id the user id.
     * @param password the user password.
     * @param email the user email.
     * @throws NullPointerException if id, password or email parameter is {@code null}.
     */
    @JsonCreator
    public User(@JsonProperty("id") String id, @JsonProperty("password") String password, @JsonProperty("email") String email) {
        checkNotNull(id);
        checkNotNull(password);
        checkNotNull(email);

        this.id = id;
        this.email = email;
        this.password = password;
    }
}
