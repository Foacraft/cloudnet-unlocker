package com.foacraft.cloudnet.unlocker.bungee

import com.foacraft.cloudnet.unlocker.bukkit.CUnlockerBukkit
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader
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
    }

    override fun onDisable() {
        PlatformInjectSupportLoader.disablePlugin("bungeecord", BungeePlugin.getInstance())
    }

}