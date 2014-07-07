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
package com.codenvy.eclipse.client;

import static com.google.common.base.Preconditions.checkNotNull;

import com.codenvy.eclipse.client.auth.AuthenticationException;

/**
 * {@link Request} implementation adapting an API request response to another type.
 * 
 * @author Kevin Pollet
 * @param <T> the {@linkplain java.lang.reflect.Type Type} of the adapted request response.
 * @param <S> the {@linkplain java.lang.reflect.Type Type} of the request response to adapt.
 */
public class RequestResponseAdaptor<T, S> implements Request<T> {
    private final Request<S> adaptee;
    private final Adaptor<T, S> adaptor;

    /**
     * Constructs an instance of {@link RequestResponseAdaptor}.
     * 
     * @param adaptee the {@link Request} to adapt.
     * @param adaptor the {@link Request} response adaptor.
     * @throws NullPointerException if adaptee or adaptor parameter is {@code null}.
     */
    RequestResponseAdaptor(Request<S> adaptee, Adaptor<T, S> adaptor) {
        checkNotNull(adaptee);
        checkNotNull(adaptor);

        this.adaptee = adaptee;
        this.adaptor = adaptor;
    }

    @Override
    public T execute() throws CodenvyException, AuthenticationException {
        return adaptor.adapt(adaptee.execute());
    }

    /**
     * The request response adaptor contract.
     * 
     * @author Kevin Pollet
     * @param <T> the {@linkplain java.lang.reflect.Type Type} of the adapted request response
     * @param <S> the {@linkplain java.lang.reflect.Type Type} of the request response to adapt.
     */
    public interface Adaptor<T, S> {
        /**
         * Adapts the request response.
         * 
         * @param response the request response to adapt
         * @return the adapted response.
         */
        T adapt(S response);
    }
}
