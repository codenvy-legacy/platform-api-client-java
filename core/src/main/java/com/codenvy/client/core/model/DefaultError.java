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
package com.codenvy.client.core.model;

import static com.google.common.base.Preconditions.checkNotNull;


import com.codenvy.client.model.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The codenvy error envelope object model.
 * 
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultError implements com.codenvy.client.model.Error {

    private final String message;

    /**
     * Constructs an instance of {@link DefaultError}.
     * 
     * @param message the error message.
     * @throws NullPointerException if message is {@code null}.
     */
    @JsonCreator
    public DefaultError(@JsonProperty("status") int status, @JsonProperty("message") String message) {
        checkNotNull(message);

        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
