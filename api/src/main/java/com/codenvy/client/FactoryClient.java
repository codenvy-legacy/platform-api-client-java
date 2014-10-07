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

import com.codenvy.client.model.Factory;
import com.codenvy.client.model.ProjectReference;

/**
 * The Codenvy Factory API client.
 *
 * @author Florent Benoit
 */
public interface FactoryClient {

    /**
     * Returns factory data
     * @param  jsonContent the content of the JSON factory
     * @return factory information.
     */
    Request<Factory> save(String jsonContent);


    /**
     * Returns factory content of a project
     * @param  {@link ProjectReference} the project to export
     * @return factory content.
     */
    Request<String> export(ProjectReference projectReference);
}
