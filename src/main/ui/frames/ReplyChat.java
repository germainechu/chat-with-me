package ui.frames;

import javax.swing.*;
import java.awt.*;

class ReplyChat {

    //MODIFIES:
    //EFFECTS: opens the gui for the reply chat
    public ReplyChat() {
        displayGUI();
    }

    private static void displayGUI() {

        JFrame frame = new JFrame("ReplyChat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700, 500);

        JTextArea ta = new JTextArea();
        ta.setBounds(150,30, 400,400);
        ta.setEditable(false);
        ta.setText("You: \n");


        JScrollPane sp = new JScrollPane(ta);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        frame.add(ta);
        frame.add(sp);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.getContentPane().add(BorderLayout.CENTER,sp);
        frame.setVisible(true);


    }


}
