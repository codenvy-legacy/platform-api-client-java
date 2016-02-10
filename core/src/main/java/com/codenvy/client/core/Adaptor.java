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

/**
 * The request response adaptor contract.
 *
 * @param <T>
 *         the {@linkplain java.lang.reflect.Type Type} of the adapted request response
 * @param <S>
 *         the {@linkplain java.lang.reflect.Type Type} of the request response to adapt.
 * @author Kevin Pollet
 */
public interface Adaptor<T, S> {
    /**
     * Adapts the request response.
     *
     * @param response
     *         the request response to adapt
     * @return the adapted response.
     */
    T adapt(S response);
}