package com.university.lab1.gems.model;

/**
 An enumeration of supported gemstone types, along with an indicator
 of whether each type belongs to the precious gemstone category.
 */
public enum GemstoneType {
    DIAMOND(true),
    RUBY(true),
    SAPPHIRE(true),
    EMERALD(true),
    AMETHYST(false),
    TOPAZ(false),
    GARNET(false),
    AQUAMARINE(false);

    private final boolean precious;

    GemstoneType(boolean precious) {
        this.precious = precious;
    }

    /**
     @return {@code true} if the gemstone type is precious,
             {@code false} if it is semi-precious.
     */
    public boolean isPrecious() {
        return precious;
    }
}
