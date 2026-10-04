package com.university.lab1.gems.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SemiPreciousGemstoneTest {

    @Test
    void shouldCreateSemiPreciousGemstone() {
        SemiPreciousGemstone amethyst =
                new SemiPreciousGemstone(
                        "Amethyst",
                        GemstoneType.AMETHYST,
                        3.0,
                        300.0,
                        70,
                        "Brazil"
                );

        assertEquals("Amethyst", amethyst.getName());
        assertEquals(
                GemstoneType.AMETHYST,
                amethyst.getType()
        );
        assertEquals(3.0, amethyst.getWeightInCarats());
        assertEquals(300.0, amethyst.getPricePerCarat());
        assertEquals(70, amethyst.getTransparencyPercent());
        assertEquals("Brazil", amethyst.getOriginRegion());
    }

    @Test
    void shouldCalculateSemiPreciousGemstoneValue() {
        SemiPreciousGemstone amethyst =
                new SemiPreciousGemstone(
                        "Amethyst",
                        GemstoneType.AMETHYST,
                        3.0,
                        300.0,
                        70,
                        "Brazil"
                );

        assertEquals(
                900.0,
                amethyst.calculateValue(),
                0.001
        );
    }

    @Test
    void shouldRejectPreciousGemstoneType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SemiPreciousGemstone(
                        "Diamond",
                        GemstoneType.DIAMOND,
                        1.5,
                        5000.0,
                        95,
                        "South Africa"
                )
        );
    }

    @Test
    void shouldUseUnknownOriginWhenOriginIsBlank() {
        SemiPreciousGemstone amethyst =
                new SemiPreciousGemstone(
                        "Amethyst",
                        GemstoneType.AMETHYST,
                        3.0,
                        300.0,
                        70,
                        ""
                );

        assertEquals(
                "Unknown",
                amethyst.getOriginRegion()
        );
    }
}

