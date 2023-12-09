package com.foacraft.cloudnet.unlocker.artifex

import eu.cloudnetservice.ext.platforminject.api.PlatformEntrypoint
import eu.cloudnetservice.ext.platforminject.api.stereotype.Dependency
import eu.cloudnetservice.ext.platforminject.api.stereotype.PlatformPlugin
import jakarta.inject.Singleton

/**
 * CloudNet-Unlocker
 * com.foacraft.cloudnet.unlocker.artifex.ArtifexPlatformPlugin
 *
 * @author scorez
 * @since 12/8/23 23:41.
 */

@Singleton
@PlatformPlugin(
    platform = "bukkit",
    name = "artifex",
    version = "1.0",
    authors = ["Score2"],
    dependencies = [Dependency(name = "CloudNet-Bridge")]
)
class ArtifexPlatformPluginBukkit : PlatformEntrypoint {

}

@Singleton
@PlatformPlugin(
    platform = "bungeecord",
    name = "artifex",
    version = "1.0",
    authors = ["Score2"],
    dependencies = [Dependency(name = "CloudNet-Bridge")]
)
class ArtifexPlatformPluginBungee : PlatformEntrypoint {

}