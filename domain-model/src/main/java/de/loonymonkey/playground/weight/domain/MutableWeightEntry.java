/**
 *
 */
package de.loonymonkey.playground.weight.domain;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Frank
 */
public class MutableWeightEntry {
    private LocalDate date;
    private float     weight;

    public MutableWeightEntry() {
        this.date = LocalDate.now();
        this.weight = 0;
    }

    public MutableWeightEntry(final WeightEntry source) {
        this.date = source.getDate();
        this.weight = source.getWeight();
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(final LocalDate date) {
        this.date = Objects.requireNonNull(date);
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(final float weight) {
        this.weight = weight;
    }
}
