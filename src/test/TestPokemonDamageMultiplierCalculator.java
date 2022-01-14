package test;

import org.junit.Assert;
import org.junit.Test;
import pokemon.PokemonDamageMultiplierCalculator;


public class TestPokemonDamageMultiplierCalculator {

    @Test
    public void testFireVsGrass() {
        PokemonDamageMultiplierCalculator calculator = new PokemonDamageMultiplierCalculator();
        String multiplier = calculator.getDamageMultiplier("fire -> grass");
        Assert.assertEquals(multiplier, "2x");
    }

    @Test
    public void testMultipleDefending() {
        PokemonDamageMultiplierCalculator calculator = new PokemonDamageMultiplierCalculator();
        String multiplier = calculator.getDamageMultiplier("fighting -> ice rock");
        Assert.assertEquals("4x", multiplier);
    }

    @Test
    public void testBlockAttack() {
        PokemonDamageMultiplierCalculator calculator = new PokemonDamageMultiplierCalculator();
        String multiplier = calculator.getDamageMultiplier("psychic -> poison dark");
        Assert.assertEquals(multiplier, "0x");
    }

    @Test
    public void testNeutralAttack() {
        PokemonDamageMultiplierCalculator calculator = new PokemonDamageMultiplierCalculator();
        String multiplier = calculator.getDamageMultiplier("water -> normal");
        Assert.assertEquals(multiplier, "1x");
    }

    @Test
    public void testIneffectiveAttack() {
        PokemonDamageMultiplierCalculator calculator = new PokemonDamageMultiplierCalculator();
        String multiplier = calculator.getDamageMultiplier("fire -> rock");
        Assert.assertEquals(multiplier, "0,5x");
    }


}