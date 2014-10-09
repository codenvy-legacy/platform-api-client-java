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
import com.codenvy.client.model.ProjectReference;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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

        // ok there we need to check if there is a logo element in the json content
        // and if it's there we will add the image as binary content of the form
        URL logoURL = null;
        JsonReader jSonReader = Json.createReader(new StringReader(jsonContent));
        JsonObject jsonObject = jSonReader.readObject();
        if (jsonObject != null) {
            JsonObject button = jsonObject.getJsonObject("button");
            if (button != null) {
                String type = button.getString("type");
                if ("logo".equals(type)) {
                    JsonObject attributes = button.getJsonObject("attributes");
                    if (attributes != null) {
                        String logoPath = attributes.getString("logo");
                        if (logoPath != null && !logoPath.isEmpty()) {
                            // found a logo
                            try {
                                logoURL = new URL(logoPath);
                            } catch (MalformedURLException e) {
                                throw new IllegalStateException("Invalid logo content found in the JSON file.", e);
                            }
                        }
                    }
                }
            }
        }


        final FormDataMultiPart formDataMultiPart = new FormDataMultiPart().field("factoryUrl", jsonContent);

        // do we have a logo
        if (logoURL != null) {
            try  {
                URLConnection urlConnection = logoURL.openConnection();
                String contentType = urlConnection.getContentType();
                FormDataBodyPart formDataBodyPart = new FormDataBodyPart(FormDataContentDisposition
                                                                                 .name("image").fileName("example").build(),
                                                                         logoURL.openStream(),
                                                                         MediaType.valueOf(contentType));

                formDataMultiPart.bodyPart(formDataBodyPart);
            } catch (IOException e) {
                throw new IllegalStateException("Invalid logo content found in the JSON file.", e);
            }
        }

        final Invocation request = getWebTarget().request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildPost(Entity.entity(formDataMultiPart, MULTIPART_FORM_DATA));

        return new SimpleRequest<Factory>(request, DefaultFactory.class, getAuthenticationManager());
    }

    /**
     * Returns factory content of a project
     *
     * @param projectReference@return
     *         factory content.
     */
    @Override
    public Request<String> export(ProjectReference projectReference) {

        final Invocation request = getWebTarget().path(projectReference.workspaceId())
                                                 .path(projectReference.name())
                                                 .request()
                                                 .accept(APPLICATION_JSON)
                                                 .buildGet();

        return new SimpleRequest<String>(request, getAuthenticationManager());
    }
}
