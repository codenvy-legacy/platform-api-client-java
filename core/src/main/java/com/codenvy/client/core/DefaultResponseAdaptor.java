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
 * @param <T>
 *         the {@linkplain java.lang.reflect.Type Type} of the adapted request response.
 * @author Florent benoit
 */
public class DefaultResponseAdaptor<T, S> implements Response<T> {

    private final Response<S> wrappedResponse;

    private final Adaptor<T, S> adaptor;

    public DefaultResponseAdaptor(Adaptor<T, S> adaptor, Response<S> wrappedResponse) {
        this.adaptor = adaptor;
        this.wrappedResponse = wrappedResponse;
    }

    /**
     * Returns the wrapped value
     *
     * @return the API request result.
     */
    @Override
    public T getValue() {
        return adaptor.adapt(wrappedResponse.getValue());
    }

    /**
     * @return the headers of the response
     */
    @Override
    public Map<String, List<Object>> getHeaders() {
        return wrappedResponse.getHeaders();
    }

    /**
     * @return the status code of the response
     */
    @Override
    public int getStatusCode() {
        return wrappedResponse.getStatusCode();
    }

}
