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
package com.codenvy.client.core;

import com.codenvy.client.Codenvy;
import com.codenvy.client.auth.Credentials;
import com.codenvy.client.core.auth.DefaultCredentialsBuilder;

import org.junit.Assert;
import org.junit.BeforeClass;

import java.io.IOException;
import java.util.Properties;


/**
 * REST client API base test.
 * 
 * @author Kevin Pollet
 */
public abstract class AbstractIT {
    private static final String REST_API_URL_PROPERTY_NAME = "rest.api.url";

    protected static final String DUMMY_USERNAME     = "dummyUsername";
    protected static final String DUMMY_PASSWORD     = "dummyPassword";
    protected static final String SDK_TOKEN_VALUE    = "123123";
    protected static final String SDK_WORKSPACE_NAME = "default";
    protected static Codenvy codenvy;
    protected static String  REST_API_URL;

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

        final Credentials credentials = new DefaultCredentialsBuilder().withUsername(DUMMY_USERNAME)
                                                                       .withPassword(DUMMY_PASSWORD)
                                                                       .build();

        codenvy = new DefaultCodenvyBuilder(REST_API_URL, DUMMY_USERNAME).withCredentials(credentials)
                                                                         .build();
    }
}
