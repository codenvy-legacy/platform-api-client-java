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

import java.util.Date;

/**
 * This class represents the project resource on Codenvy.
 * @author Florent Benoit
 */
public interface Project {
    String url();
    String visibility();
    String projectTypeId();
    String workspaceId();
    String projectTypeName();
    String name();
    String description();
    String workspaceName();
    Date   modificationDate();
    Date creationDate();
    String ideUrl();


}
