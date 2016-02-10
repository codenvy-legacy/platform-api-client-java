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

import com.codenvy.client.model.Link;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The link model class.
 *
 * @author Kevin Pollet
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultLink implements Link {
    public static final String WEB_LINK_REL_ATTRIBUTE_VALUE      = "web url";
    public static final String DOWNLOAD_LINK_REL_ATTRIBUTE_VALUE = "download result";

    private final String href;
    private final String rel;
    private final String produces;
    private final String consumes;
    private final String method;

    @JsonCreator
    public DefaultLink(@JsonProperty("href") String href,
                       @JsonProperty("rel") String rel,
                       @JsonProperty("produces") String produces,
                       @JsonProperty("consumes") String consumes,
                       @JsonProperty("method") String method) {

        this.href = href;
        this.rel = rel;
        this.produces = produces;
        this.consumes = consumes;
        this.method = method;
    }

    @Override
    public String toString() {
        return "Link [href=" + href + ", rel=" + rel + ", produces=" + produces + ", consumes=" + consumes + ", method=" + method + "]";
    }

    @Override
    public String href() {
        return href;
    }

    @Override
    public String rel() {
        return rel;
    }

    @Override
    public String produces() {
        return produces;
    }

    @Override
    public String consumes() {
        return consumes;
    }

    @Override
    public String method() {
        return method;
    }
}
