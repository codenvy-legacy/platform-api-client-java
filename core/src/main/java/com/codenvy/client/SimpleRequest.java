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

import static com.codenvy.client.auth.TokenInjectorFilter.TOKEN_PROPERTY_NAME;
import static com.google.common.base.Preconditions.checkNotNull;

import java.net.UnknownHostException;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codenvy.client.auth.AuthenticationManager;
import com.codenvy.client.auth.Token;

/**
 * {@link Request} implementation reading the body of the {@link Response}.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 * @param <T> the {@linkplain java.lang.reflect.Type Type} of the {@link Response} body.
 */
public class SimpleRequest<T> implements Request<T> {
    private final Class<T>              entityType;
    private final GenericType<T>        genericEntityType;
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
    SimpleRequest(Invocation request, Class<T> entityType, AuthenticationManager authenticationManager) {
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
    SimpleRequest(Invocation request, GenericType<T> genericEntityType, AuthenticationManager authenticationManager) {
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
                          Class<T> entityType,
                          GenericType<T> genericEntityType,
                          AuthenticationManager authenticationManager) {

        checkNotNull(request);
        checkNotNull(authenticationManager);

        this.request = request;
        this.entityType = entityType;
        this.genericEntityType = genericEntityType;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public T execute() throws CodenvyException {
        try {

            Token token = authenticationManager.getToken();
            if (token == null) {
                token = authenticationManager.authorize();
            }

            // set the token property for token injection
            request.property(TOKEN_PROPERTY_NAME, token);

            Response response = request.invoke();

            if (Status.Family.CLIENT_ERROR == response.getStatusInfo().getFamily()) {
                token = authenticationManager.refreshToken();

                // set the token property for token injection
                request.property(TOKEN_PROPERTY_NAME, token);

                response = request.invoke();
            }

            // read response
            if (genericEntityType != null) {
                return readEntity(response, genericEntityType);
            }
            return entityType.equals(Response.class) ? entityType.cast(response) : readEntity(response, entityType);

        } catch (ProcessingException e) {
            if (e.getCause() instanceof UnknownHostException) {
                throw CodenvyUnknownHostException.from((UnknownHostException)e.getCause());
            }
            throw CodenvyException.from(e);
        }
    }

    /**
     * Reads the API {@link Response} body entity.
     * 
     * @param response the API {@link Response}.
     * @param entityType the entity type to read in {@link Response} body.
     * @return the entity type instance.
     * @throws CodenvyErrorException if something goes wrong with the API call.
     */
    private T readEntity(Response response, Class<T> entityType) throws CodenvyErrorException {
        if (Status.Family.SUCCESSFUL == response.getStatusInfo().getFamily()) {
            return response.readEntity(entityType);
        }

        throw CodenvyErrorException.from(response);
    }

    /**
     * Reads the API {@link Response} body entity.
     * 
     * @param response the API {@link Response}.
     * @param genericEntityType the entity type to read in {@link Response} body.
     * @return the entity type instance.
     * @throws CodenvyErrorException if something goes wrong with the API call.
     */
    private T readEntity(Response response, GenericType<T> genericEntityType) throws CodenvyErrorException {
        if (Status.Family.SUCCESSFUL == response.getStatusInfo().getFamily()) {
            return response.readEntity(genericEntityType);
        }

        throw CodenvyErrorException.from(response);
    }
}
