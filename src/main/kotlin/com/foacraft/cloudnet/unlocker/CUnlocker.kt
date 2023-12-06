package com.foacraft.cloudnet.unlocker

import eu.cloudnetservice.driver.event.EventManager
import eu.cloudnetservice.driver.provider.CloudServiceProvider
import eu.cloudnetservice.driver.provider.ClusterNodeProvider
import eu.cloudnetservice.driver.provider.GroupConfigurationProvider
import eu.cloudnetservice.driver.provider.ServiceTaskProvider
import eu.cloudnetservice.driver.registry.injection.Service
import eu.cloudnetservice.driver.template.TemplateStorageProvider
import eu.cloudnetservice.modules.bridge.player.PlayerManager
import jakarta.inject.Inject
import jakarta.inject.Singleton

/**
 * cloudnet-unlocker
 * com.foacraft.cloudnet.unlocker.CUnlocker
 *
 * @author scorez
 * @since 12/1/23 19:20.
 */
@Singleton
class CUnlocker @Inject constructor(
    val eventManager: EventManager,
    val cloudServiceProvider: CloudServiceProvider,
    val groupConfigurationProvider: GroupConfigurationProvider,
    val serviceTaskProvider: ServiceTaskProvider,
    val clusterNodeProvider: ClusterNodeProvider,
    val templateStorageProvider: TemplateStorageProvider,
    @Service val playerManager: PlayerManager
) {

    init {
        println("Unlocking...")
        Companion.cloudServiceProvider = cloudServiceProvider
        Companion.eventManager = eventManager
        Companion.groupConfigurationProvider = groupConfigurationProvider
        Companion.serviceTaskProvider = serviceTaskProvider
        Companion.clusterNodeProvider = clusterNodeProvider
        Companion.templateStorageProvider = templateStorageProvider
        Companion.playerManager = playerManager
        println("Unlocked.")
    }

    companion object {
        lateinit var eventManager: EventManager internal set
        lateinit var cloudServiceProvider: CloudServiceProvider internal set
        lateinit var groupConfigurationProvider: GroupConfigurationProvider internal set
        lateinit var clusterNodeProvider: ClusterNodeProvider internal set
        lateinit var serviceTaskProvider: ServiceTaskProvider internal set
        lateinit var templateStorageProvider: TemplateStorageProvider internal set
        lateinit var playerManager: PlayerManager internal set
    }
}