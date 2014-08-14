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

import com.codenvy.client.model.Factory;
import com.codenvy.client.model.Link;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the factory resource on Codenvy.
 *
 * @author Florent Benoit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultFactory implements Factory {

    private String version;
    private final List<Link> links;


    /**
     * Constructs an instance of {@linkplain com.codenvy.client.model.Factory}.
     *
     */
    @JsonCreator
    public DefaultFactory(@JsonProperty("links") List<DefaultLink> links, @JsonProperty("v") String version) {
        this.links = ImmutableList.copyOf(links == null ? new ArrayList<Link>() : links);
        this.version = version;
    }

    @JsonProperty("v")
    @Override
    public String getV() {
        return version;
    }

    @JsonProperty("links")
    @Override
    public List<Link> getLinks() {
        return links;
    }

    @Override
    public Factory withWarnonclose(boolean warnonclose) {
        return null;
    }

    @Override
    public String getKeepdirectory() {
        return null;
    }
}
