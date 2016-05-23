/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
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
