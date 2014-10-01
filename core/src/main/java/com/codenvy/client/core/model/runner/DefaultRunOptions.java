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
package com.codenvy.client.core.model.runner;

import com.codenvy.client.model.runner.RunOptions;

/**
 * @author Florent Benoit
 */
public class DefaultRunOptions implements RunOptions {

    private int memorySize;

    /**
     * @return in MB the size of the memory to use for this runner
     */
    @Override
    public int getMemorySize() {
        return memorySize;
    }

    public DefaultRunOptions withMemorySize(int memorySize) {
        this.memorySize = memorySize;
        return this;
    }
}
