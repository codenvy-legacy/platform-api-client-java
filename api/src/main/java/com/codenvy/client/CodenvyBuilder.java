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

import com.codenvy.client.auth.Credentials;
import com.codenvy.client.auth.CredentialsProvider;
import com.codenvy.client.store.DataStoreFactory;

/**
 * Builder used to build a {@link com.codenvy.client.Codenvy} client.
 *
 * @author Florent Benoit
 */
public interface CodenvyBuilder {

    /**
     * Provides the user {@link Credentials} used if they are not found in storage.
     *
     * @param credentials
     *         the provided {@link Credentials}.
     * @return {@link CodenvyBuilder} instance.
     * @throws IllegalArgumentException
     *         if provided {@link Credentials} doesn't match the given username.
     */
    CodenvyBuilder withCredentials(Credentials credentials);

    /**
     * Defines the {@link DataStoreFactory} used to store the user {@link Credentials}.
     *
     * @param credentialsStoreFactory
     *         the {@link DataStoreFactory} to use.
     * @return {@link CodenvyBuilder} instance.
     */
    CodenvyBuilder withCredentialsStoreFactory(DataStoreFactory<String, Credentials> credentialsStoreFactory);

    /**
     * Defines the {@link CredentialsProvider} used to provide credentials if they are not stored or provided
     *
     * @param credentialsProvider
     *         the credentials provider.
     * @return {@link CodenvyBuilder} instance.
     */
    CodenvyBuilder withCredentialsProvider(CredentialsProvider credentialsProvider);

    /**
     * Builds the {@link com.codenvy.client.Codenvy} client.
     *
     * @return the {@link com.codenvy.client.Codenvy} client instance.
     */
    Codenvy build();
}
