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
package com.codenvy.client.model;

import com.codenvy.client.model.factory.FactoryCreator;
import com.codenvy.client.model.factory.FactoryProject;

import java.util.List;

/**
 * @author Florent Benoit
 */
public interface Factory {

    String getV();

    List<Link> getLinks();

    Factory withWarnonclose(boolean warnonclose);

    String getKeepdirectory();

    /**
     * @return project
     */
    FactoryProject project();

    /**
     * @return the creator
     */
    FactoryCreator creator();

}
