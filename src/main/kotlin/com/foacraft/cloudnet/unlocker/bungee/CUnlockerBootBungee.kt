package com.foacraft.cloudnet.unlocker.bungee

import com.foacraft.cloudnet.unlocker.artifex.ArtifexPlatformPluginBungee
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader
import net.md_5.bungee.api.ProxyServer
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.platform.Plugin
import taboolib.platform.BungeePlugin

/**
 * cloudnet-unlocker
 * com.foacraft.cloudnet.unlocker.bungee.CUnlockerBungee
 *
 * @author scorez
 * @since 12/1/23 19:24.
 */
@PlatformSide([Platform.BUNGEE])
object CUnlockerBootBungee : Plugin() {

    override fun onEnable() {
        PlatformInjectSupportLoader.loadPlugin(
            "bungeecord",
            CUnlockerBungee::class.java,
            BungeePlugin.getInstance(),
            BungeePlugin.getInstance()::class.java.classLoader.parent
        )
        // inject artifex
        ProxyServer.getInstance().pluginManager.getPlugin("Artifex")?.let { plugin ->
            PlatformInjectSupportLoader.loadPlugin(
                "bungeecord",
                ArtifexPlatformPluginBungee::class.java,
                plugin,
                plugin::class.java.classLoader.parent
            )
        }
    }

    override fun onDisable() {
        PlatformInjectSupportLoader.disablePlugin("bungeecord", BungeePlugin.getInstance())
    }

}