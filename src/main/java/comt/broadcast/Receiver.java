package comt.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver implements Runnable {
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(4455);
            byte[] buffer = new byte[512];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            String quote = new String(buffer, 0, response.getLength());
            System.out.println(quote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
