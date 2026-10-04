package com.university.lab1.gems.model;

/**
 * A semi-precious gemstone (amethyst, topaz, garnet, aquamarine, etc.).
 */
public class SemiPreciousGemstone extends Gemstone {
    private static final double SEMI_PRECIOUS_MULTIPLIER = 1.0;
    private static final String UNKNOWN_ORIGIN = "Unknown";

    private final String originRegion;

    public SemiPreciousGemstone(String name, GemstoneType type, double weightInCarats,
                                double pricePerCarat, int transparencyPercent, String originRegion) {
        super(name, type, weightInCarats, pricePerCarat, transparencyPercent);

        if (type.isPrecious()) {
            throw new IllegalArgumentException(
                    type + " belongs to precious rather than semi-precious stones");
        }
        this.originRegion = (originRegion == null || originRegion.isBlank())
                ? UNKNOWN_ORIGIN
                : originRegion;
    }

    public String getOriginRegion() {
        return originRegion;
    }

    @Override
    public double getValueMultiplier() {
        return SEMI_PRECIOUS_MULTIPLIER;
    }

    @Override
    public String getCategoryName() {
        return "Semi-precious stone";
    }
}
