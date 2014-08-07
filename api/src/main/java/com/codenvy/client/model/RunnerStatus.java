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
package com.codenvy.client.model;

import com.codenvy.client.model.builder.BuilderMetric;
import com.codenvy.client.model.runner.RunnerMetric;

import java.util.List;

/**
 * The codenvy runner object model.
 *
 * @author Florent Benoit
 */
public interface RunnerStatus {

    long stopTime();

    String debugHost();

    long debugPort();

    long processId();

    long startTime();

    RunnerState status();

    List<Link> links();

    /**
     * Returns the web {@link Link}.
     *
     * @return the web {@link Link} or {@code null}.
     */
    Link getWebLink();

    /**
     * @return statistics for the runner process
     */
    List<RunnerMetric> getRunStats();

    /**
     * @return statistics for the runner process on the build part
     */
    List<BuilderMetric> getBuildStats();

}
