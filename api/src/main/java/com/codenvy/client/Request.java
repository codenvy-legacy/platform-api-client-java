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
 * The API request contract returned by the Codenvy client API.
 *
 * @param <T>
 *         the API request return {@linkplain java.lang.reflect.Type Type}
 * @author Kevin Pollet
 */
public interface Request<T> {

    /**
     * Executes the Codenvy API request.
     *
     * @return the API request result.
     * @throws CodenvyException
     *         if something goes wrong with the API call.
     */
    T execute() throws CodenvyException;

    /**
     * Executes the Codenvy API request and then return details on the response.
     *
     * @return the API response result.
     * @throws CodenvyException
     *         if something goes wrong with the API call.
     */
    Response<T> response() throws CodenvyException;

}
