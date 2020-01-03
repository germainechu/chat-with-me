package ui.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokemonParser {

    //MODIFIES: jsonData
    //EFFECTS: parses api to get pokemon
    public String parsePokemon(String jsonData) throws JSONException {

        JSONArray pokemon = new JSONArray(jsonData);
        for (int index = 0; index < pokemon.length(); index++) {
            JSONObject pokemonName = pokemon.getJSONObject(index);
            return parseName(pokemonName);
        }
        return "nama";
    }

    //MODIFIES: pokemonName
    //EFFECTS: grabs the name from api
    private String parseName(JSONObject pokemonName) throws JSONException {
        String name = pokemonName.getString("name");

        return "Your Pokemon's name is: " + name.toUpperCase();

    }




}
