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

import com.codenvy.client.auth.Token;
import com.codenvy.client.auth.TokenBuilder;

/**
 * Token builder.
 *
 * @author Florent Benoit
 */
public class DefaultTokenBuilder implements TokenBuilder {

    /**
     * Value of the token.
     */
    private final String value;

    /**
     * Build a new token builder with the specified value
     *
     * @param value
     *         the value of the token
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
