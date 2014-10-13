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

package com.codenvy.client.core.model.project;

import com.codenvy.client.model.project.BuildersDescription;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines default builder.
 * @author Florent Benoit
 */
public class DefaultBuildersDescription implements BuildersDescription {

    private String                           defaultBuilder;

    @JsonCreator
    public DefaultBuildersDescription(
            @JsonProperty("default") String defaultBuilder) {
        this.defaultBuilder = defaultBuilder;
    }

    /**
     * @return the default builder selected (if any)
     */
    @JsonProperty("default")
    @Override
    public String defaultBuilder() {
        return defaultBuilder;
    }
}
