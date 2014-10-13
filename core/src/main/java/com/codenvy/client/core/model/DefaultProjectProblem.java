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

package com.codenvy.client.core.model;

import com.codenvy.client.model.ProjectProblem;

/**
 * @author Florent Benoit
 */
public class DefaultProjectProblem implements ProjectProblem {
    /**
     * @return error code
     */
    @Override
    public int getCode() {
        return 0;
    }

    /**
     * @return the problem's message
     */
    @Override
    public String getMessage() {
        return null;
    }
}
