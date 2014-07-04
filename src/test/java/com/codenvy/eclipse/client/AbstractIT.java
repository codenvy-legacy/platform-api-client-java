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

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.BeforeClass;

import com.codenvy.eclipse.client.auth.Credentials;


/**
 * REST client API base test.
 * 
 * @author Kevin Pollet
 */
public abstract class AbstractIT {
    private static final String   REST_API_URL_PROPERTY_NAME = "rest.api.url";

    protected static final String DUMMY_USERNAME             = "dummyUsername";
    protected static final String DUMMY_PASSWORD             = "dummyPassword";
    protected static final String SDK_TOKEN_VALUE            = "123123";
    protected static final String SDK_WORKSPACE_NAME         = "default";
    protected static Codenvy      codenvy;
    protected static String       REST_API_URL;

    @BeforeClass
    public static void initRestAPIURL() {
        final Properties codenvySdkProperties = new Properties();
        try {
            codenvySdkProperties.load(AbstractIT.class.getResourceAsStream("/codenvy-sdk.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        REST_API_URL = System.getProperty(REST_API_URL_PROPERTY_NAME, codenvySdkProperties.getProperty(REST_API_URL_PROPERTY_NAME));
        Assert.assertNotNull(REST_API_URL);

        final Credentials credentials = new Credentials.Builder().withUsername(DUMMY_USERNAME)
                                                                 .withPassword(DUMMY_PASSWORD)
                                                                 .build();

        codenvy = new Codenvy.Builder(REST_API_URL, DUMMY_USERNAME).withCredentials(credentials)
                                                                   .build();
    }
}
