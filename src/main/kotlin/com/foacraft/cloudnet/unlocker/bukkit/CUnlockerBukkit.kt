package com.foacraft.cloudnet.unlocker.bukkit

import com.foacraft.cloudnet.unlocker.CUnlocker
import com.foacraft.cloudnet.unlocker.event.ProxyChannelMessageEvent
import eu.cloudnetservice.driver.channel.ChannelMessage
import eu.cloudnetservice.driver.event.EventManager
import eu.cloudnetservice.driver.util.ModuleHelper
import eu.cloudnetservice.ext.platforminject.api.PlatformEntrypoint
import eu.cloudnetservice.ext.platforminject.api.stereotype.Dependency
import eu.cloudnetservice.ext.platforminject.api.stereotype.PlatformPlugin
import eu.cloudnetservice.node.provider.NodeMessenger
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.bukkit.plugin.Plugin

/**
 * cloudnet-unlocker
 * com.foacraft.cloudnet.unlocker.bukkit.CUnlockerBukkit
 *
 * @author scorez
 * @since 12/1/23 19:48.
 */
@Singleton
@PlatformPlugin(
    platform = "bukkit",
    name = "cloudnet-unlocker",
    version = "@project_version@",
    authors = ["Score2"],
    dependencies = [Dependency(name = "CloudNet-Bridge")]
)
class CUnlockerBukkit @Inject constructor(
    val plugin: Plugin,
    val moduleHelper: ModuleHelper,
    val eventManager: EventManager,
) : PlatformEntrypoint {

    init {
        eventManager.registerListener(ProxyChannelMessageEvent)
    }

    override fun onDisable() {
        moduleHelper.unregisterAll(plugin.javaClass.classLoader)
    }


}