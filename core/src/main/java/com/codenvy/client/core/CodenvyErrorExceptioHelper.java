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
package com.codenvy.client.core;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.ws.rs.core.Response;

import com.codenvy.client.CodenvyErrorException;
import com.codenvy.client.core.model.DefaultError;

/**
 * Helper class used to convert JAXRS exception into CodenvyException
 * @author Kevin Pollet
 */
public class CodenvyErrorExceptioHelper {

    /**
     * Reads the {@code Response} body and constructs an instance of {@link CodenvyErrorException}.
     *
     * @param response the rest API {@link javax.ws.rs.core.Response}.
     * @throws NullPointerException if response parameter is {@code null}.
     */
    public static CodenvyErrorException from(Response response) {
        final com.codenvy.client.model.Error codenvyError = checkNotNull(response).readEntity(DefaultError.class);
        return new CodenvyErrorException(response.getStatus(), codenvyError.message());
    }
}
