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

import static com.codenvy.eclipse.client.model.Link.DOWNLOAD_LINK_REL_ATTRIBUTE_VALUE;

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
public class BuilderStatus {
    public final long       taskId;
    public final long       startTime;
    public final Status     status;
    public final List<Link> links;

    @JsonCreator
    public BuilderStatus(@JsonProperty("taskId") long taskId,
                                @JsonProperty("startTime") long startTime,
                                @JsonProperty("status") Status status,
                                @JsonProperty("links") List<Link> links) {
        this.taskId = taskId;
        this.startTime = startTime;
        this.status = status;
        this.links = ImmutableList.copyOf(links == null ? new ArrayList<Link>() : links);
    }

    /**
     * Gets the build result download {@link Link}.
     * 
     * @return the download {@link Link}.
     */
    public Link getDownloadLink() {
        for (Link oneLink : links) {
            if (DOWNLOAD_LINK_REL_ATTRIBUTE_VALUE.equals(oneLink.rel)) {
                return oneLink;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CodenvyBuilderStatus [taskId=" + taskId + ", startTime=" + startTime + ", status=" + status + ", links=" + links + "]";
    }

    public enum Status {
        IN_QUEUE,
        IN_PROGRESS,
        SUCCESSFUL,
        FAILED,
        CANCELLED
    }
}
