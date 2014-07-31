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

import java.util.ServiceLoader;

/**
 * Entry point to get the codenvy client.
 * @author Florent Benoit
 */
public class CodenvyAPI {

    private static CodenvyClient client;

    public static CodenvyClient setClient(CodenvyClient codenvyClient) {
        CodenvyClient previous = client;
        client = codenvyClient;
        return previous;
    }

    /**
     * @return the Codenvy Client.
     */
    public static CodenvyClient getClient() {
        if (client == null) {
            // Use context classloader to find implementation
            ServiceLoader<CodenvyClient> codenvyClient = ServiceLoader.load(CodenvyClient.class, Thread.currentThread().getContextClassLoader());
            if (codenvyClient == null || !codenvyClient.iterator().hasNext()) {
                throw new CodenvyException("Unable to find an implementation of '" + CodenvyClient.class.getName() + "'. Check Implementation bundle is available on the platform or that implementation jar contains META-INF/services/com.codenvy.client.CodenvyClient key.");
            }

            // take first one
            client = codenvyClient.iterator().next();
        }

        return client;
    }



}