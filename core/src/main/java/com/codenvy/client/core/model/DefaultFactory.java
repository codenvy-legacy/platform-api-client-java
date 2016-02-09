/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 *  [2012] - [2016] Codenvy, S.A.
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.client.core.model;

import com.codenvy.client.core.model.factory.DefaultFactoryCreator;
import com.codenvy.client.core.model.factory.DefaultFactoryProject;
import com.codenvy.client.model.Factory;
import com.codenvy.client.model.Link;
import com.codenvy.client.model.factory.FactoryCreator;
import com.codenvy.client.model.factory.FactoryProject;
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

    /**
     * Name of the factory.
     */
    private String name;

    /**
     * Version.
     */
    private String version;

    /**
     * Links
     */
    private final List<Link> links;

    /**
     * Creator
     */
    private FactoryCreator factoryCreator;

    /**
     * Creator
     */
    private FactoryProject factoryProject;

    /**
     * Constructs an instance of {@linkplain com.codenvy.client.model.Factory}.
     *
     */
    @JsonCreator
    public DefaultFactory(@JsonProperty("links") List<DefaultLink> links, @JsonProperty("v") String version,
                          @JsonProperty("name") String name, @JsonProperty("creator") DefaultFactoryCreator factoryCreator, @JsonProperty("project") DefaultFactoryProject factoryProject) {
        this.links = ImmutableList.copyOf(links == null ? new ArrayList<Link>() : links);
        this.version = version;
        this.factoryCreator = factoryCreator;
        this.factoryProject = factoryProject;
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


    /**
     * @return the creator
     */
    @Override
    public FactoryCreator creator() {
        return factoryCreator;
    }

    /**
     * @return the project
     */
    @Override
    public FactoryProject project() {
        return factoryProject;
    }

}
