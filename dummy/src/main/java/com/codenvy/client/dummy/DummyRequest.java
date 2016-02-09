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
package com.codenvy.client.dummy;

import com.codenvy.client.CodenvyException;
import com.codenvy.client.Request;
import com.codenvy.client.Response;

import java.util.List;
import java.util.Map;

/**
 * @author Florent Benoit
 */
public class DummyRequest<T> implements Request<T> {

    private T wrapped;

    public DummyRequest(T wrapped) {
        this.wrapped = wrapped;

    }

    public T call() {
        return wrapped;
    }

    /**
     * Executes the Codenvy API request.
     *
     * @return the API request result.
     * @throws com.codenvy.client.CodenvyException
     *         if something goes wrong with the API call.
     */
    @Override
    public T execute() throws CodenvyException {
        return call();
    }

    /**
     * Executes the Codenvy API request and then return details on the response.
     *
     * @return the API response result.
     * @throws com.codenvy.client.CodenvyException
     *         if something goes wrong with the API call.
     */
    @Override
    public Response<T> response() throws CodenvyException {
        return new Response<T>() {
            @Override
            public T getValue() {
                return call();
            }

            @Override
            public Map<String, List<Object>> getHeaders() {
                return null;
            }

            @Override
            public int getStatusCode() {
                return 200;
            }
        };
    }
}
