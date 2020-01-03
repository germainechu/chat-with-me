package ui.frames;

import ui.threads.Audio;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class ChatFrame extends JFrame {

    private String username;
    private JButton send;
    private JTextArea ta;
    private JButton pokemon;
    private JTextArea chatArea;

    //MODIFIES:
    //EFFECTS: opens the setUsername GUI
    public ChatFrame() throws InvocationTargetException, InterruptedException {
        setUsername();
    }


    private void setUsername() {
        JFrame jf = new JFrame("Set Username");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(700, 500);


        ta = new JTextArea();
        ta.setBounds(150, 200, 400, 40);
        ta.setEditable(true);

        JLabel name = new JLabel("What is your username?");
        name.setBounds(150,100,400,100);


        JButton confirm = new JButton("Confirm");
        confirm.setBounds(250, 300, 200, 20);
        confirm.addActionListener(e -> {
                    this.username = ta.getText().toUpperCase();
                    displayGUI();
                }
        );
        confirm.setOpaque(true);
        confirm.setBackground(Color.cyan);

        addToFrame(jf,name,confirm);

    }

    private void addToFrame(JFrame jf, JLabel name, JButton confirm) {
        jf.add(name);
        jf.add(ta);
        jf.add(confirm);
        jf.setLayout(null);

        jf.getContentPane().add(BorderLayout.CENTER, name);
        jf.setVisible(true);
    }

    private void displayGUI() {
        JFrame frame = new JFrame(this.username + " is Chatting!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        makeFrame();

        //chatArea
        makeChatArea();
        frame.add(chatArea);

        //button tings
        buttonTings();

        frame.add(ta);
        frame.add(send);
        this.send = send;


        frame.add(pokemon);
        pokemon.addActionListener(e -> {
            try {
                new Pokemon();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);

    }

    private void makeFrame() {
        JTextArea ta = new JTextArea();
        ta.setBounds(150, 30, 400, 100);
        ta.setEditable(true);
        this.ta = ta;
    }

    private void makeChatArea() {
        JTextArea chatArea = new JTextArea();
        chatArea.setBounds(150, 200, 400, 200);
        chatArea.setEditable(false);
        this.chatArea = chatArea;

    }

    private void buttonTings() {
        send = new JButton("Send");
        send.setBounds(100, 150, 200, 30);
        send.setOpaque(true);
        send.setBackground(Color.green);
        this.send = send;

        JButton pokemon = new JButton("Pokemon me!");
        pokemon.setBounds(400, 150, 200, 30);
        pokemon.setOpaque(true);
        pokemon.setBackground(Color.YELLOW);
        this.pokemon = pokemon;
    }


    public String getUsername() {
        return this.username;
    }

    public JButton getSendButton() {
        return this.send;
    }

    public JTextArea getTextArea() {
        return this.ta;
    }

    public JTextArea getChatArea() {
        return this.chatArea;
    }


}

