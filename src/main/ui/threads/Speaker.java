package ui.threads;

import ui.frames.ChatFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

class Speaker extends Thread {


    Speaker(ChatFrame c) {
        try {
            Scanner scanner = new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket();
            InetAddress ip = InetAddress.getLocalHost();
            System.out.print("port: ");
            int port = Integer.parseInt(scanner.nextLine());
            c.getSendButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String text = c.getTextArea().getText();
                        c.getTextArea().setText("");
                        byte[] buf = text.getBytes();
                        c.getChatArea().append("YOU: " + text + "\n");
                        DatagramPacket message = new DatagramPacket(buf, buf.length, ip, port);
                        socket.send(message);
                    } catch (IOException error) {
                        System.out.println(error);
                    }
                }
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

