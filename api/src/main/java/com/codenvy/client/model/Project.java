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

package com.codenvy.client.model;

import java.util.List;
import java.util.Map;

/**
 * Project description is containing the data of a project
 *
 * @author Florent Benoit
 */
public interface Project extends ProjectReference {

    /**
     * @return user permissions for this project
     */
    List<String> userPermissions();

    /**
     * @return the attributes for this given project
     */
    Map<String, List<String>> attributes();

    /**
     * Returns runner
     * @return the runner
     */
    String runner();

    /**
     * Returns builder
     * @return the builder
     */
    String builder();

    /**
     * Returns builder environment
     * @return the builder environment
     */
    String defaultBuilderEnvironment();

    /**
     * Returns runner environment
     * @return the runner environment
     */
    String defaultRunnerEnvironment();

}
