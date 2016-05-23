/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.client.model.runner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florent Benoit
 */
public interface RunOptions {

    /**
     * @return in MB the size of the memory to use for this runner
     */
    int getMemorySize();

    /**
     * @return id of environment that should be used for running an application.
     */
    String getEnvironmentId();

    /**
     * @return recipes for the runner
     */
    List<String> getScriptFiles();

}
