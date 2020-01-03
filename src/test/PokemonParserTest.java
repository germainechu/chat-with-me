import ui.parser.PokemonParser;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

class PokemonParserTest {

    @Test
    void testParsePokemon() throws IOException {
        URL url1 = new URL("https://pokeapi.co/api/v2/pokemon/1/");
        InputStream is = url1.openStream();
        String jsonData = readSource(is);
        PokemonParser pokeParser = new PokemonParser();
        pokeParser.parsePokemon(jsonData);
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
