package de.loonymonkey.playground.domain.weight;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * @author Frank
 */
public class WeightEntryTest {
    private static final LocalDateTime VALID_DATE_TIME = LocalDateTime.now();
    private static final float         VALID_WEIGHT    = 100;

    @Test(expected = IllegalArgumentException.class)
    public void assertThatConstructorRejectsNullDateTime() {
        @SuppressWarnings("unused")
        final WeightEntry objectUnderTest = new WeightEntry(null, VALID_WEIGHT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatConstructorRejectsZeroWeight() {
        @SuppressWarnings("unused")
        final WeightEntry objectUnderTest = new WeightEntry(VALID_DATE_TIME, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatConstructorRejectsNegativeWeight() {
        @SuppressWarnings("unused")
        final WeightEntry objectUnderTest = new WeightEntry(VALID_DATE_TIME, -10);
    }
}
