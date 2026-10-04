package com.university.lab1.gems.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PreciousGemstoneTest {

    @Test
    void shouldCreatePreciousGemstone() {
        PreciousGemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        assertEquals("Diamond", diamond.getName());
        assertEquals(GemstoneType.DIAMOND, diamond.getType());
        assertEquals(1.5, diamond.getWeightInCarats());
        assertEquals(5000.0, diamond.getPricePerCarat());
        assertEquals(95, diamond.getTransparencyPercent());
        assertEquals(ClarityGrade.VVS1, diamond.getClarityGrade());
    }

    @Test
    void shouldCalculatePreciousGemstoneValue() {
        PreciousGemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        assertEquals(
                28125.0,
                diamond.calculateValue(),
                0.001
        );
    }

    @Test
    void shouldRejectNonPreciousGemstoneType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PreciousGemstone(
                        "Amethyst",
                        GemstoneType.AMETHYST,
                        3.0,
                        300.0,
                        70,
                        ClarityGrade.VS1
                )
        );
    }

    @Test
    void shouldRejectNullClarityGrade() {
        assertThrows(
                NullPointerException.class,
                () -> new PreciousGemstone(
                        "Diamond",
                        GemstoneType.DIAMOND,
                        1.5,
                        5000.0,
                        95,
                        null
                )
        );
    }
}
