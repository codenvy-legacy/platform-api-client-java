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

/**
 * This interface represents the workspace reference resource on Codenvy.
 * @author Florent Benoit
 */
public interface WorkspaceReference {

    String id();
    String name();
    String organizationId();

    /**
     * @return true if the workspace is a temporary workspace
     */
    boolean isTemporary();
}
