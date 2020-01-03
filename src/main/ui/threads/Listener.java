package ui.threads;

import ui.frames.ChatFrame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Listener extends Thread {

    private int port;
    private ChatFrame chatFrame;

    Listener(ChatFrame c) {
        this.chatFrame = c;


    }

    //REQUIRES: datagram socket
    //MODIFIES: byte[], socket
    //EFFECTS: starts the listener thread
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket(0);
            System.out.println("listening on: " +  socket.getLocalPort());
            byte[] buf = new byte[65535];
            DatagramPacket receive = null;

            while (true) {
                receive = new DatagramPacket(buf, buf.length);
                socket.receive(receive);
                this.chatFrame.getChatArea().append("SOMEONE: " + data(buf).toString() + "\n");
                buf = new byte[65535];
            }
        } catch (IOException e) {
            System.out.println("you aren't listening");
        }
    }

    private static StringBuilder data(byte[] a) {
        if (a == null) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }


}
