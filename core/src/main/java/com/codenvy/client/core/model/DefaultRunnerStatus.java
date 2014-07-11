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

import static com.codenvy.client.core.model.DefaultLink.WEB_LINK_REL_ATTRIBUTE_VALUE;

import java.util.ArrayList;
import java.util.List;

import com.codenvy.client.model.Link;
import com.codenvy.client.model.RunnerState;
import com.codenvy.client.model.RunnerStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

/**
 * The codenvy runner object model.
 * 
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultRunnerStatus implements RunnerStatus {
    private final long              stopTime;
    private final String            debugHost;
    private final long              debugPort;
    private final long              processId;
    private final long              startTime;
    private final RunnerState       status;
    private final List<Link> links;

    @JsonCreator
    public DefaultRunnerStatus(@JsonProperty("stopTime") long stopTime,
                               @JsonProperty("debugHost") String debugHost,
                               @JsonProperty("debugPort") long debugPort,
                               @JsonProperty("processId") long processId,
                               @JsonProperty("startTime") long startTime,
                               @JsonProperty("status") RunnerState status,
                               @JsonProperty("links") List<DefaultLink> links) {

        this.stopTime = stopTime;
        this.debugHost = debugHost;
        this.debugPort = debugPort;
        this.processId = processId;
        this.startTime = startTime;
        this.status = status;
        this.links = ImmutableList.copyOf(links == null ? new ArrayList<Link>() : links);
    }

    @Override
    public long stopTime() {
        return stopTime;
    }

    @Override
    public String debugHost() {
        return debugHost;
    }

    @Override
    public long debugPort() {
        return debugPort;
    }

    @Override
    public long processId() {
        return processId;
    }

    @Override
    public long startTime() {
        return startTime;
    }

    @Override
    public RunnerState status() {
        return status;
    }

    @Override
    public List<Link> links() {
        return links;
    }

    /**
     * Returns the web {@link DefaultLink}.
     *
     * @return the web {@link DefaultLink} or {@code null}.
     */
    @Override
    public Link getWebLink() {
        for (Link oneLink : links) {
            if (WEB_LINK_REL_ATTRIBUTE_VALUE.equalsIgnoreCase(oneLink.rel())) {
                return oneLink;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CodenvyRunnerStatus [stopTime=" + stopTime + ", debugHost=" + debugHost + ", debugPort=" + debugPort + ", processId="
               + processId + ", startTime=" + startTime + ", status=" + status + ", links=" + links + "]";
    }

}
