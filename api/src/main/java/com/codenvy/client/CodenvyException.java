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


/**
 * The base Codenvy exception.
 *
 * @author Kevin Pollet
 */
public class CodenvyException extends RuntimeException {
    private static final long serialVersionUID = 197371454259368237L;

    /**
     * Constructs an instance of {@link CodenvyException} from an {@link Exception}.
     *
     * @param e
     *         the {@link Exception} instance.
     * @return the created {@link CodenvyException}.
     */
    public static CodenvyException from(Exception e) {
        return new CodenvyException(e.getMessage(), e.getCause());
    }

    /**
     * Constructs an instance of {@link CodenvyException}.
     *
     * @param message
     *         the exception message.
     * @param cause
     *         the {@link Throwable} cause
     */
    public CodenvyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an instance of {@link CodenvyException}.
     *
     * @param message
     *         the exception message.
     */
    public CodenvyException(String message) {
        super(message);
    }
}
