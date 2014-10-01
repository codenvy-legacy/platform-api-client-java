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

import com.codenvy.client.FactoryClient;
import com.codenvy.client.Request;
import com.codenvy.client.core.auth.AuthenticationManager;
import com.codenvy.client.core.model.DefaultFactory;
import com.codenvy.client.model.Factory;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;

/**
 * The Codenvy factory API client.
 *
 * @author Florent Benoit
 */
public class DefaultFactoryClient extends AbstractClient implements FactoryClient {

    /**
     * Constructs an instance of {@link com.codenvy.client.core.DefaultFactoryClient}.
     *
     * @param url
     *         the Codenvy platform URL.
     * @param authenticationManager
     *         the {@link com.codenvy.client.core.auth.AuthenticationManager}.
     * @throws NullPointerException
     *         if url or authenticationManager parameter is {@code null}.
     */
    DefaultFactoryClient(String url, AuthenticationManager authenticationManager) {
        super(url, "factory", authenticationManager);
    }


    /**
     * Returns factory data
     *
     * @param jsonContent
     *         the content of the JSON factory
     * @return factory information.
     */

    @Override
    public Request<Factory> save(String jsonContent) {
        final FormDataMultiPart formDataMultiPart = new FormDataMultiPart().field("factoryUrl", jsonContent);

        final Invocation request = getWebTarget().request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildPost(Entity.entity(formDataMultiPart, MULTIPART_FORM_DATA));

        return new SimpleRequest<Factory>(request, DefaultFactory.class, getAuthenticationManager());
    }
}
