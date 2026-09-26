package com.university.lab1.gems.model;

/** A simplified grading of a gemstone's clarity based on the international
 * GIA clarity scale. Each grade is assigned a coefficient that affects
 *  the final value of the gemstone.
 *
 *
 * FL - Flawless: no inclusions or blemishes visible under 10× magnification.
 * IF - Internally Flawless: no internal inclusions visible under 10× magnification;
 *      only minor surface blemishes may be present.
 *  VVS1 - Very, Very Slightly Included 1: inclusions are extremely difficult
 *      to see under 10× magnification.
 *  VVS2 - Very, Very Slightly Included 2: inclusions are very difficult
 *      to see under 10× magnification.
 *  VS1 - Very Slightly Included 1: minor inclusions are difficult to see
 *      under 10× magnification.
 *  VS2 - Very Slightly Included 2: minor inclusions are somewhat easy to see
 *      under 10× magnification.
 *  SI1 - Slightly Included 1: inclusions are noticeable under 10× magnification.
 *  SI2 - Slightly Included 2: inclusions are easily noticeable under
 *      10× magnification.
 *  I1 - Included 1: inclusions are obvious and may affect transparency
 *      and durability.
 *  */

public enum ClarityGrade {

    FL(1.50),
    IF(1.35),
    VVS1(1.25),
    VVS2(1.20),
    VS1(1.10),
    VS2(1.05),
    SI1(1.00),
    SI2(0.90),
    I1(0.75);

    private final double clarityFactor;

    ClarityGrade(double clarityFactor) {
        this.clarityFactor = clarityFactor;
    }

    public double getClarityFactor() {
        return clarityFactor;
    }
}
