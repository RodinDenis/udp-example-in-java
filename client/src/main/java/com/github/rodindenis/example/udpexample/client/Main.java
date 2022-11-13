package com.github.rodindenis.example.udpexample.client;

import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte[] buf = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 50_000);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        socket.close();
        String received = new String(
                packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);

    }
}
