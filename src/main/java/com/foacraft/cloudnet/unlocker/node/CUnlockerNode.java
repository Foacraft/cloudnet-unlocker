package com.foacraft.cloudnet.unlocker.node;

import eu.cloudnetservice.driver.event.EventManager;
import eu.cloudnetservice.driver.module.ModuleLifeCycle;
import eu.cloudnetservice.driver.module.ModuleTask;
import eu.cloudnetservice.driver.module.driver.DriverModule;
import eu.cloudnetservice.driver.util.ModuleHelper;
import eu.cloudnetservice.node.module.listener.PluginIncludeListener;
import jakarta.inject.Singleton;

/**
 * cloudnet-unlocker
 * com.foacraft.cloudnet.unlocker.node.CUnlockerNode
 *
 * @author scorez
 * @since 12/3/23 22:31.
 */
@Singleton
public class CUnlockerNode extends DriverModule {

    @ModuleTask(order = 64, lifecycle = ModuleLifeCycle.LOADED)
    public void initListeners(
            EventManager eventManager,
            ModuleHelper moduleHelper
    ) {
        eventManager.registerListener(new PluginIncludeListener(
                "cloudnet-unlocker",
                getClass(),
                moduleHelper,
                (service) -> true
        ));
    }

}
