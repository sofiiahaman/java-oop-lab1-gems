package com.university.lab1.gems.model;

import java.util.Objects;

/**
 * A precious gemstone (diamond, ruby, sapphire, emerald, etc.).
 */
public class PreciousGemstone extends Gemstone{
    private static final double PRECIOUS_BASE_MULTIPLIER = 3.0;

    private final ClarityGrade clarityGrade;

    public PreciousGemstone(String name, GemstoneType type,  double weightInCarats,
                            double pricePerCarat, int transparencyPercent, ClarityGrade clarityGrade) {
        super(name, type, weightInCarats, pricePerCarat, transparencyPercent);

        if (!type.isPrecious()) {
            throw new IllegalArgumentException(type + "is not a precious gemstone");
        }

        this.clarityGrade = Objects.requireNonNull(clarityGrade,
                "A clarity grade is required for a precious stone");
    }

    public ClarityGrade getClarityGrade() {return clarityGrade;}

    @Override
    public double getValueMultiplier() {
        return PRECIOUS_BASE_MULTIPLIER * clarityGrade.getClarityFactor();
    }

    @Override
    public String getCategoryName() {
        return "Precious stone";
    }

}
