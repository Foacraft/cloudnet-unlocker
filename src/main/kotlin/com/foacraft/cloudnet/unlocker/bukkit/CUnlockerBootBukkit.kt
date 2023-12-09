package com.foacraft.cloudnet.unlocker.bukkit

import com.foacraft.cloudnet.unlocker.artifex.ArtifexPlatformPluginBukkit
import eu.cloudnetservice.ext.platforminject.loader.PlatformInjectSupportLoader
import org.bukkit.Bukkit
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.platform.Plugin
import taboolib.platform.BukkitPlugin

/**
 * cloudnet-unlocker
 * com.foacraft.cloudnet.unlocker.bungee.CUnlockerBukkit
 *
 * @author scorez
 * @since 12/1/23 19:24.
 */
@PlatformSide([Platform.BUKKIT])
object CUnlockerBootBukkit : Plugin() {

    override fun onEnable() {
        PlatformInjectSupportLoader.loadPlugin(
            "bukkit",
            CUnlockerBukkit::class.java,
            BukkitPlugin.getInstance(),
            BukkitPlugin.getInstance()::class.java.classLoader.parent
        )
        // inject artifex
        Bukkit.getPluginManager().getPlugin("Artifex")?.let { plugin ->
            PlatformInjectSupportLoader.loadPlugin(
            "bukkit",
                ArtifexPlatformPluginBukkit::class.java,
                plugin,
                plugin::class.java.classLoader.parent
            )
        }
    }

    override fun onDisable() {
        PlatformInjectSupportLoader.disablePlugin("bukkit", BukkitPlugin.getInstance())
    }

}