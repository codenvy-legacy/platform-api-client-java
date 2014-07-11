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

import com.codenvy.client.auth.Token;
import com.codenvy.client.auth.TokenBuilder;
import com.codenvy.client.core.model.DefaultProject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Token builder.
 * @author Florent Benoit
 */
public class DefaultTokenBuilder implements TokenBuilder {

    /**
     * Value of the token.
     */
    private String value;

    /**
     * Build a new token builder with the specified value
     * @param value the value of the token
     */
    public DefaultTokenBuilder(String value) {
        this.value = value;
    }

    /**
     * @return instance of {@link com.codenvy.client.auth.Token}
     */
    @Override
    public Token build() {
        return new DefaultToken(value);
    }
}
