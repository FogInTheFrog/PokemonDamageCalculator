package pokemon;

public class PokemonDamageMultiplierCalculator {
    private PokemonRequestsForwarder pokemonRequestsForwarder;

    public PokemonDamageMultiplierCalculator() {
        this.pokemonRequestsForwarder = new PokemonRequestsForwarder();
    }

    public String getDamageMultiplier(String pokemonTypes) {
        String[] parts = pokemonTypes.split(" -> ");
        assert parts.length == 2;

        String[] attackingPokemonTypes = parts[0].split(" ");
        String[] defendingPokemonTypes = parts[1].split(" ");
        assert attackingPokemonTypes.length > 0;
        assert defendingPokemonTypes.length > 0;

        double multiplier = 1;

        for (String attackingPokemonType: attackingPokemonTypes) {
            assert attackingPokemonType.length() > 0;

            PokemonResponse pokemonResponse = pokemonRequestsForwarder.sendRequest(attackingPokemonType);

            for (String defendingPokemonType : defendingPokemonTypes) {
                assert defendingPokemonType.length() > 0;

                multiplier *= pokemonResponse.getMultiplierVsType(defendingPokemonType);
            }
        }

        if (multiplier == (long) multiplier) {
            return String.format("%dx", (long)multiplier);
        }
        else {
            return String.format("%.1fx", multiplier);
        }
    }
}
