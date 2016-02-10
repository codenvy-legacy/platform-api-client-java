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

import com.codenvy.client.model.User;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@linkplain com.codenvy.client.core.DefaultUserClient UserService} tests.
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
        Assert.assertNotNull(currentUser.id());
        Assert.assertNotNull(currentUser.password());
        Assert.assertNotNull(currentUser.email());
    }
}
