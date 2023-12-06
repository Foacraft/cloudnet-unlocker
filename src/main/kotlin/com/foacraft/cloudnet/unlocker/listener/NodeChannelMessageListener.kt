package com.foacraft.cloudnet.unlocker.listener

import com.foacraft.cloudnet.unlocker.event.ProxyChannelMessageEvent
import eu.cloudnetservice.driver.event.EventListener
import eu.cloudnetservice.driver.event.events.channel.ChannelMessageReceiveEvent

/**
 * CloudNet-Unlocker
 * com.foacraft.cloudnet.unlocker.listener.NodeChannelMessageListener
 *
 * @author scorez
 * @since 12/6/23 20:51.
 */
object NodeChannelMessageListener {

    @EventListener
    fun e(e: ChannelMessageReceiveEvent) {
        ProxyChannelMessageEvent(e).call()
    }

}