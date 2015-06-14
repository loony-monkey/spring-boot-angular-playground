/**
 *
 */
package de.loonymonkey.playground.weight.domain;

import java.time.LocalDate;

import org.apache.commons.lang.Validate;

/**
 * @author Frank
 */
public class WeightEntry {
    private final LocalDate date;
    private final float     weight;

    public WeightEntry(final LocalDate date, final float weight) {
        Validate.notNull(date, "|date| must not be null!");
        Validate.isTrue(weight > 0, "|weight| must be non-negative!");
        this.date = date;
        this.weight = weight;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public float getWeight() {
        return this.weight;
    }
}
