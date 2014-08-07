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

import static com.codenvy.client.core.auth.TokenInjectorFilter.TOKEN_PROPERTY_NAME;
import static com.google.common.base.Preconditions.checkNotNull;

import java.net.UnknownHostException;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response.Status;

import com.codenvy.client.CodenvyErrorException;
import com.codenvy.client.CodenvyException;
import com.codenvy.client.CodenvyUnknownHostException;
import com.codenvy.client.Request;
import com.codenvy.client.Response;
import com.codenvy.client.auth.Token;
import com.codenvy.client.core.auth.AuthenticationManager;

/**
 * {@link com.codenvy.client.Request} implementation reading the body of the {@link javax.ws.rs.core.Response}.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 * @author Florent Benoit
 * @param <T> the {@linkplain java.lang.reflect.Type Type} of the {@link javax.ws.rs.core.Response} body.
 */
public class SimpleRequest<T> implements Request<T> {
    private final Class<? extends T>              entityType;
    private final GenericType<? extends T>        genericEntityType;
    private final Invocation            request;
    private final AuthenticationManager authenticationManager;

    /**
     * Constructs an instance of {@link SimpleRequest}.
     * 
     * @param request the request to invoke.
     * @param entityType the request response entity {@linkplain java.lang.reflect.Type Type}.
     * @param authenticationManager the {@link AuthenticationManager} instance.
     * @throws NullPointerException if request, entityType or authenticationManager parameter is {@code null}.
     */
    SimpleRequest(Invocation request, Class<? extends T> entityType, AuthenticationManager authenticationManager) {
        this(request, entityType, null, authenticationManager);
        checkNotNull(entityType);
    }

    /**
     * Constructs an instance of {@link SimpleRequest}.
     * 
     * @param request the request to invoke.
     * @param genericEntityType the request response entity {@link GenericType}.
     * @param authenticationManager the {@link AuthenticationManager} instance.
     * @throws NullPointerException if request, genericEntityType or authenticationManager parameter is {@code null}.
     */
    SimpleRequest(Invocation request, GenericType<? extends T> genericEntityType, AuthenticationManager authenticationManager) {
        this(request, null, genericEntityType, authenticationManager);
        checkNotNull(genericEntityType);
    }

    /**
     * Constructs an instance of {@link SimpleRequest}.
     * 
     * @param request the request to invoke.
     * @param entityType the request response entity {@linkplain java.lang.reflect.Type Type}.
     * @param genericEntityType the request response entity {@link GenericType}.
     * @param authenticationManager the {@link AuthenticationManager} instance.
     * @throws NullPointerException if request or authenticationManager parameter is {@code null}.
     */
    private SimpleRequest(Invocation request,
                          Class<? extends T> entityType,
                          GenericType<? extends T> genericEntityType,
                          AuthenticationManager authenticationManager) {

        checkNotNull(request);
        checkNotNull(authenticationManager);

        this.request = request;
        this.entityType = entityType;
        this.genericEntityType = genericEntityType;
        this.authenticationManager = authenticationManager;
    }



    /**
     * Executes the Codenvy API request.
     *
     * @return the API request result.
     * @throws CodenvyException if something goes wrong with the API call.
     */
    @Override
    public T execute() throws CodenvyException {
        // return the wrapped value
        return response().getValue();
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
        try {

            Token token = authenticationManager.getToken();
            if (token == null) {
                token = authenticationManager.authorize();
            }

            // set the token property for token injection
            request.property(TOKEN_PROPERTY_NAME, token);

            javax.ws.rs.core.Response response = request.invoke();

            // Token should be refresh only when forbidden is returned (and not for the whole Status.Family.CLIENT_ERROR)
            // else it will ask token when using hasResource method which return 404 error (which doesn't need to perform again the authentication)
            if (Status.FORBIDDEN == response.getStatusInfo()) {
                token = authenticationManager.refreshToken();

                // set the token property for token injection
                request.property(TOKEN_PROPERTY_NAME, token);

                response = request.invoke();
            }

            // read response
            if (genericEntityType != null) {
                return new DefaultResponse(response, readEntity(response, genericEntityType));
            }
            return new DefaultResponse(response, entityType.equals(javax.ws.rs.core.Response.class) ? entityType.cast(response) : readEntity(response, entityType));

        } catch (ProcessingException e) {
            if (e.getCause() instanceof UnknownHostException) {
                throw CodenvyUnknownHostException.from((UnknownHostException)e.getCause());
            }
            throw CodenvyException.from(e);
        }
    }

    /**
     * Reads the API {@link javax.ws.rs.core.Response} body entity.
     * 
     * @param response the API {@link javax.ws.rs.core.Response}.
     * @param entityType the entity type to read in {@link javax.ws.rs.core.Response} body.
     * @return the entity type instance.
     * @throws com.codenvy.client.CodenvyErrorException if something goes wrong with the API call.
     */
    private T readEntity(javax.ws.rs.core.Response response, Class<? extends T> entityType) throws CodenvyErrorException {
        if (Status.Family.SUCCESSFUL == response.getStatusInfo().getFamily()) {
            return response.readEntity(entityType);
        }

        throw CodenvyErrorExceptioHelper.from(response);
    }

    /**
     * Reads the API {@link javax.ws.rs.core.Response} body entity.
     * 
     * @param response the API {@link javax.ws.rs.core.Response}.
     * @param genericEntityType the entity type to read in {@link javax.ws.rs.core.Response} body.
     * @return the entity type instance.
     * @throws CodenvyErrorException if something goes wrong with the API call.
     */
    private T readEntity(javax.ws.rs.core.Response response, GenericType<? extends T> genericEntityType) throws CodenvyErrorException {
        if (Status.Family.SUCCESSFUL == response.getStatusInfo().getFamily()) {
            return response.readEntity(genericEntityType);
        }

        throw CodenvyErrorExceptioHelper.from(response);
    }
}
