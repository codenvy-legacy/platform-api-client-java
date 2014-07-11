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

/**
 * The codenvy builder object model.
 *
 * @author Florent Benoit
 */
public interface BuilderStatus {
    long       taskId();
    long       startTime();
    BuilderState status();
    List<Link> links();

    /**
     * Gets the build result download {@link Link}.
     *
     * @return the download {@link Link}.
     */
    Link getDownloadLink();
}
