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
package com.codenvy.eclipse.client.model;

import static com.codenvy.eclipse.client.model.Link.WEB_LINK_REL_ATTRIBUTE_VALUE;

import java.util.ArrayList;
import java.util.List;

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
public class RunnerStatus {
    public final long       stopTime;
    public final String     debugHost;
    public final long       debugPort;
    public final long       processId;
    public final long       startTime;
    public final Status     status;
    public final List<Link> links;

    @JsonCreator
    public RunnerStatus(@JsonProperty("stopTime") long stopTime,
                        @JsonProperty("debugHost") String debugHost,
                        @JsonProperty("debugPort") long debugPort,
                        @JsonProperty("processId") long processId,
                        @JsonProperty("startTime") long startTime,
                        @JsonProperty("status") Status status,
                        @JsonProperty("links") List<Link> links) {

        this.stopTime = stopTime;
        this.debugHost = debugHost;
        this.debugPort = debugPort;
        this.processId = processId;
        this.startTime = startTime;
        this.status = status;
        this.links = ImmutableList.copyOf(links == null ? new ArrayList<Link>() : links);
    }

    /**
     * Returns the web {@link Link}.
     * 
     * @return the web {@link Link} or {@code null}.
     */
    public Link getWebLink() {
        for (Link oneLink : links) {
            if (WEB_LINK_REL_ATTRIBUTE_VALUE.equalsIgnoreCase(oneLink.rel)) {
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

    public enum Status {
        NEW,
        RUNNING,
        CANCELLED,
        FAILED,
        STOPPED
    }
}
