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
package com.codenvy.client.model.project;

import java.util.Map;

/**
 * Defines the configuration for a given runner.
 *
 * @author Florent Benoit
 */
public interface RunnerConfiguration {

    /**
     * @return amount of RAM for this configuration in megabytes.
     */
    int ram();

    /**
     * @return runtime options (runner type and(or) receipt specific).
     */
    Map<String, String> options();

    /**
     * @return environment variables (runner type and(or) receipt specific).
     */
    Map<String, String> variables();

}
