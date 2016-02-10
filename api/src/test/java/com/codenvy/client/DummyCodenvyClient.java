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
package com.codenvy.client;

import com.codenvy.client.auth.CredentialsBuilder;
import com.codenvy.client.auth.TokenBuilder;
import com.codenvy.client.model.ProjectBuilder;
import com.codenvy.client.model.runner.RunOptionsBuilder;

/**
 * Dummy implementation used to check SPI loading.
 *
 * @author Florent Benoit
 */
public class DummyCodenvyClient implements CodenvyClient {

    @Override
    public CredentialsBuilder newCredentialsBuilder() {
        return null;
    }

    @Override
    public CodenvyBuilder newCodenvyBuilder(String url, String username) {
        return null;
    }

    @Override
    public ProjectBuilder newProjectBuilder() {
        return null;
    }

    @Override
    public TokenBuilder newTokenBuilder(String value) {
        return null;
    }

    /**
     * @return {@link com.codenvy.client.model.runner.RunOptionsBuilder} instance
     */
    @Override
    public RunOptionsBuilder newRunOptionsBuilder() {
        return null;
    }
}
