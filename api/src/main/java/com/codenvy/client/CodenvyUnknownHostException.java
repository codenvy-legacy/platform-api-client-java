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
package com.codenvy.client;

import java.net.UnknownHostException;

/**
 * Exceptions thrown if a request is done on an unknown host.
 *
 * @author Kevin Pollet
 * @see UnknownHostException
 */
public class CodenvyUnknownHostException extends CodenvyException {
    private static final long serialVersionUID = 6895081544136542396L;

    /**
     * Constructs an instance of {@link CodenvyUnknownHostException} from an {@link UnknownHostException}.
     *
     * @param e
     *         the {@link UnknownHostException} instance.
     * @return the {@link CodenvyUnknownHostException} instance.
     */
    public static CodenvyUnknownHostException from(UnknownHostException e) {
        return new CodenvyUnknownHostException(e.getMessage(), e);
    }

    /**
     * Constructs an instance of {@link CodenvyUnknownHostException}.
     *
     * @param message
     *         the exception message.
     * @param cause
     *         the exception cause.
     */
    public CodenvyUnknownHostException(String message, Throwable cause) {
        super(message, cause);
    }
}
