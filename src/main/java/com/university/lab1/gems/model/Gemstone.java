package com.university.lab1.gems.model;

import java.util.Objects;

/**

 An abstract base class that represents a gemstone (precious or
 semi-precious). Encapsulates characteristics common to all gemstones:
 name, type, weight, base price per carat, and transparency.
 */
public abstract class Gemstone {
    private String name;
    private final GemstoneType type;
    private double weightInCarats;
    private double pricePerCarat;
    private int transparencyPercent;

    protected Gemstone(String name, GemstoneType type, double weightInCarats,
                    double pricePerCarat, int transparencyPercent) {
        this.name = validateName(name);
        this.type = Objects.requireNonNull(type, "Gemstone type cannot be null");
        this.weightInCarats = validateWeight(weightInCarats);
        this.pricePerCarat = validatePrice(pricePerCarat);
        this.transparencyPercent = validateTransparency(transparencyPercent);
    }

    private static String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Gemstone name cannot be blank");
        }

        return name;
    }

    private static double validateWeight(double weight) {
        if (weight <= 0.0) {
            throw new IllegalArgumentException("Gemstone weight must be positive");
        }

        return weight;
    }

    private static double validatePrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        return price;
    }

    private static int validateTransparency(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Transparency must be in range 0...100%");
        }
        return percent;
    }

    public String getName(String name) {
        return name;
    }

    public double getWeight(double weight) {
        return weight;
    }

    public double getPricePerCarat(double price) {
        return price;
    }

    public int getTransparencyPercent(int percent) {
        return percent;
    }

    /**
     A coefficient representing the value of the gemstone category.

     @return the value coefficient used in {@link #calculateValue()}
     */
    public abstract double getValueMultiplier();

    public abstract String getCategoryName();

    /**
     Calculates the estimated value of the gemstone using the formula:
     weight (carats) * base price per carat * category value coefficient.

     @return the value of the gemstone in arbitrary units
     */
    public double calculateValue() {
        return weightInCarats * pricePerCarat * getValueMultiplier();
    }

    public int compareTo(Gemstone other) {
        return Double.compare(this.calculateValue(), other.calculateValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Gemstone)) {
            return false;
        }
        Gemstone other = (Gemstone) obj;
        return type == other.type
                && Double.compare(weightInCarats, other.weightInCarats) == 0
                && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, weightInCarats);
    }
}
