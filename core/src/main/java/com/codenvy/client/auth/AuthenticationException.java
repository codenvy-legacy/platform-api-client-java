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
package com.codenvy.client.auth;


/**
 * Exception thrown if the user cannot be authenticated.
 * 
 * @author Kevin Pollet
 */
public class AuthenticationException extends RuntimeException {
    private static final long serialVersionUID = -700004295566607674L;

    /**
     * Constructs an instance of {@link AuthenticationException}.
     * 
     * @param message the exception message.
     */
    public AuthenticationException(String message) {
        super(message);
    }
}
