package pokemon;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class PokemonRequestsForwarder {
    private final String serverNameTemplate = "https://pokeapi.co/api/v2/type/{type}";

    public PokemonRequestsForwarder() {}

    public PokemonResponse sendRequest(String type) {
        try {
            HttpResponse<String> stringResponse =
                    Unirest.get(serverNameTemplate).routeParam("type", type).asString();

            return new PokemonResponse(stringResponse.getBody(), type);
        }
        catch (UnirestException e) {
            System.out.println("Failed to Unirest GET data with type: " + type);
        }

        return null;
    }
}
