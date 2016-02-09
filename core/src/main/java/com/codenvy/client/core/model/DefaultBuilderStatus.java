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

import com.codenvy.client.model.BuilderState;
import com.codenvy.client.model.BuilderStatus;
import com.codenvy.client.model.Link;
import com.codenvy.client.model.builder.BuilderMetric;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import static com.codenvy.client.core.model.DefaultLink.DOWNLOAD_LINK_REL_ATTRIBUTE_VALUE;

/**
 * The codenvy runner object model.
 *
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultBuilderStatus implements BuilderStatus {
    private final long                taskId;
    private final long                startTime;
    private final BuilderState        status;
    private final List<Link>          links;
    private final List<BuilderMetric> builderMetrics;

    @JsonCreator
    public DefaultBuilderStatus(@JsonProperty("taskId") long taskId,
                                @JsonProperty("startTime") long startTime,
                                @JsonProperty("status") BuilderState status,
                                @JsonProperty("links") List<DefaultLink> links,
                                @JsonProperty("buildStats") List<DefaultMetric> builderMetrics
                               ) {
        this.taskId = taskId;
        this.startTime = startTime;
        this.status = status;
        this.links = ImmutableList.copyOf(links == null ? new ArrayList<Link>() : links);
        this.builderMetrics = ImmutableList.copyOf(builderMetrics == null ? new ArrayList<BuilderMetric>() : builderMetrics);
    }

    /**
     * Gets the build result download {@link DefaultLink}.
     *
     * @return the download {@link DefaultLink}.
     */
    public Link getDownloadLink() {
        for (Link oneLink : links) {
            if (DOWNLOAD_LINK_REL_ATTRIBUTE_VALUE.equals(oneLink.rel())) {
                return oneLink;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CodenvyBuilderStatus [taskId=" + taskId + ", startTime=" + startTime + ", status=" + status + ", links=" + links +
               ", buildStats=" + builderMetrics + "]";
    }

    /**
     * @return statistics for the runner process on the build part
     */
    @Override
    public List<BuilderMetric> getBuildStats() {
        return builderMetrics;
    }

    @Override
    public long taskId() {
        return taskId;
    }

    @Override
    public long startTime() {
        return startTime;
    }

    @Override
    public BuilderState status() {
        return status;
    }

    @Override
    public List<Link> links() {
        return links;
    }
}
