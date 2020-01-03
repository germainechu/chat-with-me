package ui.frames;

import org.json.JSONException;
import ui.parser.PokemonParser;
import ui.threads.Audio;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

import static java.lang.Thread.sleep;

class Pokemon {

    private PokemonParser pp = new PokemonParser();
    private Random random;
    private ChatFrame cf;
    private Audio audio = new Audio();


    Pokemon() throws InterruptedException {
        random  = new Random();
        displayGUI();

    }



    private void displayGUI() {
        JFrame frame = new JFrame("Pokemon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700, 500);

        JButton sing = new JButton("Click Me!!");
        sing.setBounds(225,10,300,100);
        sing.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 20));
        sing.setOpaque(true);
        sing.setBackground(Color.cyan);

        JTextArea ta = new JTextArea();
        ta.setBounds(100,175, 600,200);
        ta.setEditable(false);
        ta.setText(this.parse());
        Font font = new Font("Comic Sans MS", Font.BOLD, 25);
        ta.setFont(font);


        frame.add(ta);
        frame.add(sing);
        sing.addActionListener(e ->  audio.playSound("/Users/gchu/Downloads/pokemon.wav"));
        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void play() {
        audio.playSound("/Users/gchu/Downloads/pokemon.wav");
    }

    private String parse() {

        try {
            String relativePath = "/" + random.nextInt(500) + "/";
            URL url1 = new URL("https://pokeapi.co/api/v2/pokemon");
            URL url2 = new URL(url1.toExternalForm() + relativePath);
            InputStream is = url2.openStream();
            String jsonData = readSource(is);
            PokemonParser pokeParser = new PokemonParser();
            return pokeParser.parsePokemon(jsonData);


        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }
        return "did not work, sorry!";
    }

    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append("[");
            sb.append(line);
            sb.append("\n");
            sb.append("]");
        }

        br.close();

        return sb.toString();
    }
}
