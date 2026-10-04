package com.university.lab1.gems;

import com.university.lab1.gems.collection.Necklace;
import com.university.lab1.gems.model.ClarityGrade;
import com.university.lab1.gems.model.Gemstone;
import com.university.lab1.gems.model.GemstoneType;
import com.university.lab1.gems.model.PreciousGemstone;
import com.university.lab1.gems.model.SemiPreciousGemstone;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Gems Laboratory Work ===");
        System.out.println();

        // Creating precious gemstones
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

        Gemstone sapphire = new PreciousGemstone(
                "Sapphire",
                GemstoneType.SAPPHIRE,
                2.5,
                2000.0,
                90,
                ClarityGrade.VS2
        );

        // Creating semi-precious gemstones
        Gemstone amethyst = new SemiPreciousGemstone(
                "Amethyst",
                GemstoneType.AMETHYST,
                3.0,
                300.0,
                70,
                "Brazil"
        );

        Gemstone topaz = new SemiPreciousGemstone(
                "Topaz",
                GemstoneType.TOPAZ,
                2.5,
                400.0,
                80,
                "Sri Lanka"
        );

        // Creating a necklace
        Necklace necklace = new Necklace("Royal Necklace");

        necklace.addGemstone(diamond);
        necklace.addGemstone(ruby);
        necklace.addGemstone(sapphire);
        necklace.addGemstone(amethyst);
        necklace.addGemstone(topaz);

        // Display gemstones
        System.out.println("Necklace: " + necklace.getTitle());
        System.out.println("Number of gemstones: " + necklace.size());
        System.out.println();

        System.out.println("Gemstones:");

        for (Gemstone gemstone : necklace.getGemstones()) {
            System.out.println(gemstone);
        }

        // Total weight
        System.out.println();
        System.out.printf(
                "Total weight: %.2f carats%n",
                necklace.calculateTotalWeightInCarats());

        // Total value
        System.out.printf(
                "Total value: %.2f%n",
                necklace.calculateTotalValue());

        // Sorting by value
        System.out.println();
        System.out.println("Gemstones sorted by value:");

        List<Gemstone> sortedGemstones =
                necklace.getGemstonesSortedByValue();

        for (Gemstone gemstone : sortedGemstones) {
            System.out.printf(
                    "%s - %.2f%n",
                    gemstone.getName(),
                    gemstone.calculateValue());
        }

        // Searching by transparency
        System.out.println();
        System.out.println(
                "Gemstones with transparency from 80% to 100%:");

        List<Gemstone> transparentGemstones =
                necklace.findByTransparency(80, 100);

        for (Gemstone gemstone : transparentGemstones) {
            System.out.printf(
                    "%s - %d%%%n",
                    gemstone.getName(),
                    gemstone.getTransparencyPercent());
        }

        // Demonstrating polymorphism
        System.out.println();
        System.out.println("Polymorphism demonstration:");

        for (Gemstone gemstone : necklace.getGemstones()) {
            System.out.printf(
                    "%s -> %s%n",
                    gemstone.getName(),
                    gemstone.getCategoryName());
        }
    }

}
