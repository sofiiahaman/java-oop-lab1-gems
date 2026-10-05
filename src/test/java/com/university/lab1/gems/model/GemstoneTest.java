package com.university.lab1.gems.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GemstoneTest {

    @Test
    void shouldRejectBlankName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PreciousGemstone(
                        "",
                        GemstoneType.DIAMOND,
                        1.5,
                        5000.0,
                        95,
                        ClarityGrade.VVS1
                )
        );
    }

    @Test
    void shouldRejectNullType() {
        assertThrows(
                NullPointerException.class,
                () -> new PreciousGemstone(
                        "Diamond",
                        null,
                        1.5,
                        5000.0,
                        95,
                        ClarityGrade.VVS1
                )
        );
    }

    @Test
    void shouldRejectNonPositiveWeight() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PreciousGemstone(
                        "Diamond",
                        GemstoneType.DIAMOND,
                        0.0,
                        5000.0,
                        95,
                        ClarityGrade.VVS1
                )
        );
    }

    @Test
    void shouldRejectNegativePrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PreciousGemstone(
                        "Diamond",
                        GemstoneType.DIAMOND,
                        1.5,
                        -100.0,
                        95,
                        ClarityGrade.VVS1
                )
        );
    }

    @Test
    void shouldRejectInvalidTransparency() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PreciousGemstone(
                        "Diamond",
                        GemstoneType.DIAMOND,
                        1.5,
                        5000.0,
                        101,
                        ClarityGrade.VVS1
                )
        );
    }

    @Test
    void shouldCompareGemstonesByValue() {
        Gemstone cheaperGemstone = new SemiPreciousGemstone(
                "Amethyst",
                GemstoneType.AMETHYST,
                3.0,
                300.0,
                70,
                "Brazil"
        );

        Gemstone expensiveGemstone = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        assertTrue(
                cheaperGemstone.compareTo(expensiveGemstone) < 0
        );

        assertTrue(
                expensiveGemstone.compareTo(cheaperGemstone) > 0
        );
    }

    @Test
    void shouldReturnEqualForSameGemstoneData() {
        Gemstone firstDiamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        Gemstone secondDiamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS2
        );

        assertEquals(firstDiamond, secondDiamond);
        assertEquals(
                firstDiamond.hashCode(),
                secondDiamond.hashCode()
        );
    }

    @Test
    void shouldReturnNotEqualForDifferentGemstones() {
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

        assertNotEquals(diamond, ruby);
    }

    @Test
    void shouldReturnReadableString() {
        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        String result = diamond.toString();
        System.out.println(result);

        assertTrue(result.contains("Diamond"));
        assertTrue(result.contains("Precious stone"));
        assertTrue(result.contains("1.50"));
        assertTrue(result.contains("95%"));
        assertTrue(result.contains("28125.00"));
    }

    @Test
    void shouldReturnSameObjectAsEqual() {
        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        assertEquals(diamond, diamond);
    }

    @Test
    void shouldReturnFalseWhenComparedWithNull() {
        Gemstone diamond = new PreciousGemstone(
                "Diamond",
                GemstoneType.DIAMOND,
                1.5,
                5000.0,
                95,
                ClarityGrade.VVS1
        );

        assertFalse(diamond.equals(null));
    }
}

