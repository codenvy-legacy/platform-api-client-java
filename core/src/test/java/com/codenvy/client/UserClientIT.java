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

import org.junit.Assert;
import org.junit.Test;

import com.codenvy.client.model.User;

/**
 * {@linkplain com.codenvy.client.UserClient UserService} tests.
 * 
 * @author Kevin Pollet
 * @author Stéphane Daviet
 */
public class UserClientIT extends AbstractIT {
    @Test
    public void testGetCurrentUser() {
        final User currentUser = codenvy.user()
                                        .current()
                                        .execute();

        Assert.assertNotNull(currentUser);
        Assert.assertNotNull(currentUser.id);
        Assert.assertNotNull(currentUser.password);
        Assert.assertNotNull(currentUser.email);
    }
}
