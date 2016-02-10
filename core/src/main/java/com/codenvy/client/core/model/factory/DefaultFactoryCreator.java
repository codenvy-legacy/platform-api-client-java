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
package com.codenvy.client.core.model.factory;

import com.codenvy.client.model.factory.FactoryCreator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Factory creator
 * @author Florent Benoit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultFactoryCreator implements FactoryCreator {

    private long created;

    @JsonCreator
    public DefaultFactoryCreator(@JsonProperty("created") long created) {
        this.created = created;
    }

    @Override
    public long created() {
        return created;
    }
}
