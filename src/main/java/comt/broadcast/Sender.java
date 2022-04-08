package comt.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender implements Runnable {

    @Override
    public void run() {
        try {
            InetAddress address = InetAddress.getByName("192.168.1.255");
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            byte[] buffer = "test UDP broadcast message".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4455);
            socket.send(packet);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
