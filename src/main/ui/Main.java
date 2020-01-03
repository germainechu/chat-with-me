package ui;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Scanner;

import model.client.AdminClient;
import ui.parser.PokemonParser;
import model.client.RegularClient;
import model.server.ServerProfile;
import org.json.JSONException;

public class Main {
    private static int code = 31415;
    private static List<RegularClient> regularClients;
    private int pokemonID;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        (new Main()).setup();
        System.out.println("Select one of the following: \n [1] : Get Me A Pokemon! \n [2] : Send new message \n ");
        Integer n = input.nextInt();
        (new Main()).switcher(n);

    }

    private void switcher(Integer n) {
        Scanner input = new Scanner(System.in);
        switch (n) {
            case 1:
                System.out.println("Please pick a number to generate a pokemon from 1 - 1021");
                pokemonID = input.nextInt();
                this.parse();
                break;

            case 2:
                RegularClient regular = new RegularClient(" ",new ServerProfile("Test", "Test"));
                break;

            default:
                break;
        }

    }

    private void parse() {

        try {
            String relativePath = "/" + pokemonID + "/";
            URL url1 = new URL("https://pokeapi.co/api/v2/pokemon");
            URL url2 = new URL(url1.toExternalForm() + relativePath);
            System.out.println(url2);
            InputStream is = url2.openStream();
            String jsonData = readSource(is);
            PokemonParser pokeParser = new PokemonParser();
            pokeParser.parsePokemon(jsonData);

        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }

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

    private void setup() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to your LAN chat! You will have regular privileges unless specified. Please enter "
                + "the code for AdminPrivileges if you have it: ");
        Integer inputCode = input.nextInt();
        if (inputCode.equals(code)) {
            System.out.println("Welcome AdminClient. What would you like to set your name as? ");
            String name = input.next();
            AdminClient ac = new AdminClient(name);
            System.out.println("Your Admin Username is: " + ac.getName());
        } else {
            System.out.println("Welcome RegularClient. What would you like to set your name as? ");
            String name = input.next();
            RegularClient rc = new RegularClient(name,new ServerProfile("", ""));
            System.out.println("Your username is: " + rc.getName());
        }
    }


}


