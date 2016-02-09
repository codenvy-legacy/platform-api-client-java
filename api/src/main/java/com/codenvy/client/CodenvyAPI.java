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

import java.util.ServiceLoader;

/**
 * Entry point to get the codenvy client.
 *
 * @author Florent Benoit
 */
public class CodenvyAPI {

    /**
     * Unique instance of this client.
     */
    private static volatile CodenvyClient client;

    /**
     * Utility class so no public constructor.
     */
    private CodenvyAPI() {

    }

    /**
     * Sets the Codenvy client {@link com.codenvy.client.CodenvyClient} instance.
     *
     * @param codenvyClient
     *         the instance of the codenvy client
     * @return the previous instance of {@link com.codenvy.client.CodenvyClient}
     */
    public static synchronized CodenvyClient setClient(CodenvyClient codenvyClient) {
        CodenvyClient previous = CodenvyAPI.client;
        CodenvyAPI.client = codenvyClient;
        return previous;
    }


    /**
     * @return the Codenvy Client.
     */
    public static synchronized CodenvyClient getClient() {
        if (client == null) {
            // Use context classloader to find implementation
            ServiceLoader<CodenvyClient> codenvyClient =
                    ServiceLoader.load(CodenvyClient.class, Thread.currentThread().getContextClassLoader());
            if (!codenvyClient.iterator().hasNext()) {
                throw new CodenvyException("Unable to find an implementation of '" + CodenvyClient.class.getName() +
                                           "'. Check Implementation bundle is available on the platform or that implementation jar contains META-INF/services/com.codenvy.client.CodenvyClient key.");
            }

            // take first one
            client = codenvyClient.iterator().next();
        }

        return client;
    }


}
