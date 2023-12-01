package com.foacraft.cloudnet.unlocker.event

import eu.cloudnetservice.driver.channel.ChannelMessage
import eu.cloudnetservice.driver.event.EventListener
import eu.cloudnetservice.driver.event.events.channel.ChannelMessageReceiveEvent
import taboolib.common.platform.event.ProxyEvent
import java.util.concurrent.CompletableFuture

/**
 * cloudnet-unlocker
 * com.foacraft.cloudnet.unlocker.event.CloudChannelMessageEvent
 *
 * @author scorez
 * @since 12/1/23 20:20.
 */
class ProxyChannelMessageEvent(
    val origin: ChannelMessageReceiveEvent
) : ProxyEvent() {

    val sender get() = origin.sender()
    val targets get() = origin.targets()
    val channel get() = origin.channel()
    val message get() = origin.message()
    val channelMessage get() = origin.channelMessage()
    val networkChannel get() = origin.networkChannel()
    val content get() = origin.content()
    val query get() = origin.query()
    val queryResponse get() = origin.queryResponse()

    fun queryResponse(queryResponse: ChannelMessage) = origin.queryResponse(queryResponse)
    fun queryResponse(queryResponse: CompletableFuture<ChannelMessage>) = origin.queryResponse(queryResponse)

    override val allowCancelled: Boolean
        get() = false

    companion object {

        @EventListener
        fun e(e: ChannelMessageReceiveEvent) {
            println("收信")
            ProxyChannelMessageEvent(e).call()
        }

    }
}