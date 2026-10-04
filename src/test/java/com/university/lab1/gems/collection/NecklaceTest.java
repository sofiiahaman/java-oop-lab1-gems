package com.university.lab1.gems.collection;

import com.university.lab1.gems.model.ClarityGrade;
import com.university.lab1.gems.model.Gemstone;
import com.university.lab1.gems.model.GemstoneType;
import com.university.lab1.gems.model.PreciousGemstone;
import com.university.lab1.gems.model.SemiPreciousGemstone;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NecklaceTest {

    @Test
    void shouldCreateEmptyNecklace() {
        Necklace necklace = new Necklace("Royal Necklace");

        assertEquals("Royal Necklace", necklace.getTitle());
        assertEquals(0, necklace.size());
    }

    @Test
    void shouldAddGemstone() {
        Necklace necklace = new Necklace("Royal Necklace");

        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        necklace.addGemstone(diamond);

        assertEquals(1, necklace.size());
        assertTrue(necklace.getGemstones().contains(diamond));
    }

    @Test
    void shouldRemoveGemstone() {
        Necklace necklace = new Necklace("Royal Necklace");

        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        necklace.addGemstone(diamond);

        boolean removed = necklace.removeGemstone(diamond);

        assertTrue(removed);
        assertEquals(0, necklace.size());
        assertFalse(necklace.getGemstones().contains(diamond));
    }

    @Test
    void shouldCalculateTotalWeight() {
        Necklace necklace = new Necklace("Royal Necklace");

        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        Gemstone amethyst = new SemiPreciousGemstone(
                "Amethyst",
                GemstoneType.AMETHYST,
                3.0,
                300.0,
                70,
                "Brazil"
        );

        necklace.addGemstone(diamond);
        necklace.addGemstone(amethyst);

        assertEquals(
                4.5,
                necklace.calculateTotalWeightInCarats(),
                0.001
        );
    }

    @Test
    void shouldCalculateTotalValue() {
        Necklace necklace = new Necklace("Royal Necklace");

        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        Gemstone amethyst = new SemiPreciousGemstone(
                "Amethyst",
                GemstoneType.AMETHYST,
                3.0,
                300.0,
                70,
                "Brazil"
        );

        necklace.addGemstone(diamond);
        necklace.addGemstone(amethyst);

        assertEquals(
                29025.0,
                necklace.calculateTotalValue(),
                0.001
        );
    }

    @Test
    void shouldSortGemstonesByValue() {
        Necklace necklace = new Necklace("Royal Necklace");

        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        Gemstone amethyst = new SemiPreciousGemstone(
                "Amethyst",
                GemstoneType.AMETHYST,
                3.0,
                300.0,
                70,
                "Brazil"
        );

        Gemstone ruby = new PreciousGemstone(
                "Ruby",
                GemstoneType.RUBY,
                2.0,
                3000.0,
                85,
                ClarityGrade.VS1
        );

        necklace.addGemstone(diamond);
        necklace.addGemstone(amethyst);
        necklace.addGemstone(ruby);

        List<Gemstone> sortedGemstones =
                necklace.getGemstonesSortedByValue();

        assertEquals(amethyst, sortedGemstones.get(0));
        assertEquals(ruby, sortedGemstones.get(1));
        assertEquals(diamond, sortedGemstones.get(2));
    }

    @Test
    void shouldFindGemstonesByTransparency() {
        Necklace necklace = new Necklace("Royal Necklace");

        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        Gemstone ruby = new PreciousGemstone(
                "Ruby",
                GemstoneType.RUBY,
                2.0,
                3000.0,
                85,
                ClarityGrade.VS1
        );

        Gemstone amethyst = new SemiPreciousGemstone(
                "Amethyst",
                GemstoneType.AMETHYST,
                3.0,
                300.0,
                70,
                "Brazil"
        );

        necklace.addGemstone(diamond);
        necklace.addGemstone(ruby);
        necklace.addGemstone(amethyst);

        List<Gemstone> result =
                necklace.findByTransparency(80, 100);

        assertEquals(2, result.size());
        assertTrue(result.contains(diamond));
        assertTrue(result.contains(ruby));
        assertFalse(result.contains(amethyst));
    }

    @Test
    void shouldRejectInvalidTransparencyRange() {
        Necklace necklace = new Necklace("Royal Necklace");

        assertThrows(
                IllegalArgumentException.class,
                () -> necklace.findByTransparency(100, 50)
        );
    }

    @Test
    void shouldRejectNullGemstone() {
        Necklace necklace = new Necklace("Royal Necklace");

        assertThrows(
                NullPointerException.class,
                () -> necklace.addGemstone(null)
        );
    }
}
