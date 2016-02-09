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
package com.codenvy.client.core;

import com.codenvy.client.Response;

import java.util.List;
import java.util.Map;

/**
 * Implementation of {@link com.codenvy.client.Response}
 * It provides the data for providing the value, headers and status code
 *
 * @author Florent Benoit
 */
public class DefaultResponse<T> implements Response<T> {

    /**
     * Wrapped object.
     */
    private final T value;

    /**
     * JAX-RS Response
     */
    private final javax.ws.rs.core.Response jaxRsResponse;


    /**
     * Default constructor wrapping value and response
     *
     * @param jaxRsResponse
     *         the JAX-RS response
     * @param value
     *         the value unwrapped from the response
     */
    public DefaultResponse(javax.ws.rs.core.Response jaxRsResponse, T value) {
        this.jaxRsResponse = jaxRsResponse;
        this.value = value;
    }


    /**
     * Returns the wrapped value
     *
     * @return the API request result.
     */
    @Override
    public T getValue() {
        return value;
    }

    /**
     * @return the headers of the response
     */
    @Override
    public Map<String, List<Object>> getHeaders() {
        return jaxRsResponse.getHeaders();
    }

    /**
     * @return the status code of the response
     */
    @Override
    public int getStatusCode() {
        return jaxRsResponse.getStatus();
    }
}
