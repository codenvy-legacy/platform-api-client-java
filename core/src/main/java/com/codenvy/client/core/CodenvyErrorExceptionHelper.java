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

import com.codenvy.client.CodenvyErrorException;
import com.codenvy.client.core.model.DefaultError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Helper class used to convert JAXRS exception into CodenvyException
 *
 * @author Kevin Pollet
 */
public class CodenvyErrorExceptionHelper {

    /**
     * Utility class so no public constructor.
     */
    private CodenvyErrorExceptionHelper() {

    }

    /**
     * Reads the {@code Response} body and constructs an instance of {@link CodenvyErrorException}.
     *
     * @param response
     *         the rest API {@link javax.ws.rs.core.Response}.
     * @throws NullPointerException
     *         if response parameter is {@code null}.
     */
    public static CodenvyErrorException from(Response response) {

        // Handle case where we recevied an internal error
        MediaType mediaType = response.getMediaType();
        if ("text".equals(mediaType.getType())) {
            return new CodenvyErrorException(response.getStatus(), response.getStatusInfo().getReasonPhrase().concat(":").concat(response.readEntity(String.class)));
        }
        final com.codenvy.client.model.Error codenvyError = checkNotNull(response).readEntity(DefaultError.class);
        return new CodenvyErrorException(response.getStatus(), codenvyError.message());
    }
}
