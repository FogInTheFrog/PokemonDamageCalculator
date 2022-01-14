package pokemon;

public class Main {

    public static void main(String[] args) {
        PokemonDamageMultiplierCalculator calculator = new PokemonDamageMultiplierCalculator();
        System.out.println(calculator.getDamageMultiplier("fire -> grass"));
        System.out.println(calculator.getDamageMultiplier("fighting -> ice rock"));
        System.out.println(calculator.getDamageMultiplier("psychic -> poison dark"));
        System.out.println(calculator.getDamageMultiplier("water -> normal"));
        System.out.println(calculator.getDamageMultiplier("fire -> rock"));

        // output:
        // 2x
        // 4x
        // 0x
        // 1x
        // 0,5x
    }
}
