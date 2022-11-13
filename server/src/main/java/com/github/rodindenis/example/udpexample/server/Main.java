package com.github.rodindenis.example.udpexample.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramSocket socket = new DatagramSocket(50_000);
        socket.receive(packet);
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);
        packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
        socket.close();
    }
}
