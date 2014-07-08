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

import com.codenvy.client.auth.AuthenticationException;



/**
 * The API request contract returned by the Codenvy client API.
 * 
 * @author Kevin Pollet
 * @param <T> the API request return {@linkplain java.lang.reflect.Type Type}
 */
public interface Request<T> {
    /**
     * Executes the Codenvy API request.
     * 
     * @return the API request result.
     * @throws CodenvyException if something goes wrong with the API call.
     */
    T execute() throws CodenvyException, AuthenticationException;
}