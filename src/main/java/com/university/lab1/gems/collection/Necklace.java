package com.university.lab1.gems.collection;

import com.university.lab1.gems.model.Gemstone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a necklace consisting of gemstones.
 * Provides operations for managing stones and calculating
 * the total weight and value of the necklace.
 */
public class Necklace {

    private final String title;
    private final List<Gemstone> gemstones;

    public Necklace(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Necklace title cannot be blank");
        }

        this.title = title;
        this.gemstones = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    /**
     * Adds a gemstone to the necklace.
     *
     * @param gemstone gemstone to add
     */
    public void addGemstone(Gemstone gemstone) {
        Objects.requireNonNull(
                gemstone,
                "Gemstone cannot be null");

        gemstones.add(gemstone);
    }

    /**
     * Removes a gemstone from the necklace.
     *
     * @param gemstone gemstone to remove
     * @return true if the gemstone was removed
     */
    public boolean removeGemstone(Gemstone gemstone) {
        return gemstones.remove(gemstone);
    }

    /**
     * Returns the number of gemstones.
     *
     * @return number of gemstones
     */
    public int size() {
        return gemstones.size();
    }

    /**
     * Returns an unmodifiable view of the gemstones.
     *
     * @return list of gemstones
     */
    public List<Gemstone> getGemstones() {
        return Collections.unmodifiableList(gemstones);
    }

    /**
     * Calculates the total weight of all gemstones.
     *
     * @return total weight in carats
     */
    public double calculateTotalWeightInCarats() {
        double totalWeight = 0.0;

        for (Gemstone gemstone : gemstones) {
            totalWeight += gemstone.getWeightInCarats();
        }

        return totalWeight;
    }

    /**
     * Calculates the total value of all gemstones.
     *
     * @return total value
     */
    public double calculateTotalValue() {
        double totalValue = 0.0;

        for (Gemstone gemstone : gemstones) {
            totalValue += gemstone.calculateValue();
        }

        return totalValue;
    }

    /**
     * Returns gemstones sorted by their value
     * in ascending order.
     *
     * @return a new sorted list
     */
    public List<Gemstone> getGemstonesSortedByValue() {
        List<Gemstone> sortedGemstones =
                new ArrayList<>(gemstones);

        Collections.sort(sortedGemstones);

        return sortedGemstones;
    }

    /**
     * Finds gemstones within the specified
     * transparency range.
     *
     * @param minTransparency minimum transparency
     * @param maxTransparency maximum transparency
     * @return list of matching gemstones
     */
    public List<Gemstone> findByTransparency(
            int minTransparency,
            int maxTransparency) {

        if (minTransparency < 0
                || maxTransparency > 100
                || minTransparency > maxTransparency) {
            throw new IllegalArgumentException(
                    "Invalid transparency range");
        }

        List<Gemstone> matchingGemstones =
                new ArrayList<>();

        for (Gemstone gemstone : gemstones) {
            int transparency =
                    gemstone.getTransparencyPercent();

            if (transparency >= minTransparency
                    && transparency <= maxTransparency) {
                matchingGemstones.add(gemstone);
            }
        }

        return matchingGemstones;
    }
}