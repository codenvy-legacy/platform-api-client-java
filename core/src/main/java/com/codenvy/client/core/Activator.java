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
package com.codenvy.client.core;

import com.codenvy.client.CodenvyAPI;
import com.codenvy.client.CodenvyClient;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Properties;

/**
 * OSGi Activator that will register the Codenvy Client
 *
 * @author Florent Benoit
 */
public class Activator implements BundleActivator {


    /**
     * Previous Codenvy client implementation
     */
    private CodenvyClient previous;

    /**
     * Called when this bundle is started so the Framework can perform the bundle-specific activities necessary to start this
     * bundle. This method can be used to register services or to allocate any resources that this bundle needs.
     * <p/>
     * <p/>
     * This method must complete and return to its caller in a timely manner.
     *
     * @param context
     *         The execution context of the bundle being started.
     * @throws Exception
     *         If this method throws an exception, this bundle is marked as stopped and the Framework will remove this
     *         bundle's listeners, unregister all services registered by this bundle, and release all services used by this bundle.
     */
    public void start(BundleContext context) throws Exception {

        // build implementation
        DefaultCodenvyClient defaultCodenvyClient = new DefaultCodenvyClient();

        // Sets it first in the API/SPI
        this.previous = CodenvyAPI.setClient(defaultCodenvyClient);

        // Also register it as OSGi Service...

        // add as property the implementation name
        Dictionary props = new Properties();
        props.put(CodenvyClient.class.getName(), DefaultCodenvyClient.class.getName());

        // register
        context.registerService(CodenvyClient.class.getName(), defaultCodenvyClient, props);
    }

    /**
     * Called when this bundle is stopped so the Framework can perform the bundle-specific activities necessary to stop the
     * bundle. In general, this method should undo the work that the <code>BundleActivator.start</code> method started. There
     * should be no active threads that were started by this bundle when this bundle returns. A stopped bundle must not call any
     * Framework objects.
     * <p/>
     * <p/>
     * This method must complete and return to its caller in a timely manner.
     *
     * @param context
     *         The execution context of the bundle being stopped.
     * @throws Exception
     *         If this method throws an exception, the bundle is still marked as stopped, and the Framework will remove
     *         the bundle's listeners, unregister all services registered by the bundle, and release all services used by the bundle.
     */
    public void stop(BundleContext context) throws Exception {
        // unregister
        CodenvyAPI.setClient(previous);
    }
}
