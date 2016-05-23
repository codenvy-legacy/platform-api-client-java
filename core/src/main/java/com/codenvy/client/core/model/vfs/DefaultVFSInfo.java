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
package com.codenvy.client.core.model.vfs;

import com.codenvy.client.model.vfs.VfsInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Florent Benoit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultVFSInfo implements VfsInfo {

        /**
         * Constructs an instance of {@link DefaultVFSInfo}.
         *
         * @throws NullPointerException
         *         if message is {@code null}.
         */
        @JsonCreator
        public DefaultVFSInfo() {
        }


}
