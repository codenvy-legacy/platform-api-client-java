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

import com.codenvy.client.model.Version;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This class represents the version resource on Codenvy.
 *
 * @author Florent Benoit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultVersion implements Version {
    private final String specificationVendor;
    private final String implementationVendor;
    private final String specificationTitle;
    private final String specificationVersion;
    private final String implementationVersion;
    private final String scmRevision;


    /**
     * Constructs an instance of {@linkplain com.codenvy.client.core.model.DefaultVersion}.
     *
     * @param specificationVendor
     * @param implementationVendor
     * @param specificationTitle
     * @param specificationVersion
     * @param implementationVersion
     * @param scmRevision
     */
    @JsonCreator
    public DefaultVersion(@JsonProperty("specificationVendor") String specificationVendor,
                          @JsonProperty("implementationVendor") String implementationVendor,
                          @JsonProperty("specificationTitle") String specificationTitle,
                          @JsonProperty("specificationVersion") String specificationVersion,
                          @JsonProperty("implementationVersion") String implementationVersion,
                          @JsonProperty("scmRevision") String scmRevision) {
        checkNotNull(specificationVendor);
        checkNotNull(implementationVendor);
        checkNotNull(specificationTitle);
        checkNotNull(specificationVersion);
        checkNotNull(implementationVersion);
        checkNotNull(scmRevision);

        this.specificationVendor = specificationVendor;
        this.implementationVendor = implementationVendor;
        this.specificationTitle = specificationTitle;
        this.specificationVersion = specificationVersion;
        this.implementationVersion = implementationVersion;
        this.scmRevision = scmRevision;
    }

    /**
     * @return specification vendor
     */
    @Override
    public String specificationVendor() {
        return specificationVendor;
    }

    /**
     * @return implementation vendor
     */
    @Override
    public String implementationVendor() {
        return implementationVendor;
    }

    /**
     * @return specification title
     */
    @Override
    public String specificationTitle() {
        return specificationTitle;
    }

    /**
     * @return specification version
     */
    @Override
    public String specificationVersion() {
        return specificationVersion;
    }

    /**
     * @return implementation version
     */
    @Override
    public String implementationVersion() {
        return implementationVersion;
    }

    /**
     * @return scm revision
     */
    @Override
    public String scmRevision() {
        return scmRevision;
    }
}
