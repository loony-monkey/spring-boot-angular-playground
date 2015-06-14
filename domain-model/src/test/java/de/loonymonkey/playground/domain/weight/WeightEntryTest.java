package de.loonymonkey.playground.domain.weight;

import java.time.LocalDate;

import org.junit.Test;

import de.loonymonkey.playground.weight.domain.WeightEntry;

/**
 * @author Frank
 */
public class WeightEntryTest {
    private static final LocalDate VALID_DATE   = LocalDate.now();
    private static final float     VALID_WEIGHT = 100;

    @Test(expected = IllegalArgumentException.class)
    public void assertThatConstructorRejectsNullDateTime() {
        @SuppressWarnings("unused")
        final WeightEntry objectUnderTest = new WeightEntry(null, VALID_WEIGHT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatConstructorRejectsZeroWeight() {
        @SuppressWarnings("unused")
        final WeightEntry objectUnderTest = new WeightEntry(VALID_DATE, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatConstructorRejectsNegativeWeight() {
        @SuppressWarnings("unused")
        final WeightEntry objectUnderTest = new WeightEntry(VALID_DATE, -10);
    }
}
