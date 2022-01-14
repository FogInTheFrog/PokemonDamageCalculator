package pokemon;

import org.json.JSONArray;
import org.json.JSONObject;

public class PokemonResponse {
    private final JSONObject jsonResponse;
    private final String type;

    public PokemonResponse(String unparsedStringResponse, String type) {
        this.jsonResponse = new JSONObject(unparsedStringResponse);
        this.type = type;
    }

    public double getMultiplierVsType(String defenderType) {
        final JSONObject damageRelations = jsonResponse.getJSONObject("damage_relations");
        final JSONArray doubleDamageTo = damageRelations.getJSONArray("double_damage_to");
        int multiplier = 1;

        for (int i = 0; i < doubleDamageTo.length(); i++) {
            JSONObject pokemonType = doubleDamageTo.getJSONObject(i);
            if (pokemonType.getString("name").equals(defenderType)) {
                return 2;
            }
        }

        final JSONArray halfDamageTo = damageRelations.getJSONArray("half_damage_to");
        for (int i = 0; i < halfDamageTo.length(); i++) {
            JSONObject pokemonType = halfDamageTo.getJSONObject(i);
            if (pokemonType.getString("name").equals(defenderType)) {
                return 0.5;
            }
        }

        final JSONArray noDamageTo = damageRelations.getJSONArray("no_damage_to");
        for (int i = 0; i < noDamageTo.length(); i++) {
            JSONObject pokemonType = noDamageTo.getJSONObject(i);
            if (pokemonType.getString("name").equals(defenderType)) {
                return 0;
            }
        }

        return multiplier;
    }
}
