package mwn.dk.legotrainapp

import java.net.DatagramPacket
import java.net.InetAddress
import java.net.DatagramSocket


class UDPSender(private val host: String, private val port: Int) {

    suspend fun send(packet: String) {
        try {
            val message = packet.toByteArray()
            println(message)
            val address = InetAddress.getByName(host)
            val p = DatagramPacket(message, message.size, address, port)
            val dsocket = DatagramSocket()
            dsocket.send(p)
            dsocket.close()
        } catch (e: Exception) {
            System.err.println(e)
        }

    }

}