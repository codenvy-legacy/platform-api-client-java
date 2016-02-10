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

import java.util.List;
import java.util.Map;

/**
 * The API response returned by the Codenvy client API.
 *
 * @param <T>
 *         the API request return {@linkplain java.lang.reflect.Type Type}
 * @author Florent Benoit
 */
public interface Response<T> {

    /**
     * Returns the wrapped value
     *
     * @return the API request result.
     */
    T getValue();

    /**
     * @return the headers of the response
     */
    Map<String, List<Object>> getHeaders();

    /**
     * @return the status code of the response
     */
    int getStatusCode();

}
