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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.google.common.base.Preconditions.checkNotNull;

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
     * @param message
     *         the error message.
     * @throws NullPointerException
     *         if message is {@code null}.
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
