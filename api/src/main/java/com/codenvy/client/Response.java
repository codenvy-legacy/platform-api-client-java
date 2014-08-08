/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.client;

import java.util.List;
import java.util.Map;

/**
 * The API response returned by the Codenvy client API.
 * 
 * @author Florent Benoit
 * @param <T> the API request return {@linkplain java.lang.reflect.Type Type}
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