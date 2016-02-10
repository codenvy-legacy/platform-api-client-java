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
package com.codenvy.client.dummy.auth;

import com.codenvy.client.auth.Token;

/**
 * Dummy token class.
 *
 * @author Florent Benoit
 */
public class DummyToken implements Token {
    private final String value;

    /**
     * Constructs an instance of {@linkplain DummyToken}.
     *
     * @param value
     *         the authentication token.
     */
    public DummyToken(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DummyToken other = (DummyToken) obj;

        return this.value.equals(other.value);
    }

    @Override
    public String value() {
        return value;
    }
}
