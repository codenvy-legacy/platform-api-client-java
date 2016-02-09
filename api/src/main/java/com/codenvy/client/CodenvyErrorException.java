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
 * Exception thrown when something is wrong with the REST API.
 *
 * @author Kevin Pollet
 */
public class CodenvyErrorException extends RuntimeException {
    private static final long serialVersionUID = 7031838814322889179L;

    private final int status;

    /**
     * Constructs an instance of {@link CodenvyErrorException}.
     *
     * @param status
     *         the HTTP status code.
     * @param message
     *         the error message.
     */
    public CodenvyErrorException(int status, String message) {
        super(message);

        this.status = status;
    }

    /**
     * Returns the HTTP status code.
     *
     * @return the HTTP status code.
     */
    public int getStatus() {
        return status;
    }
}
