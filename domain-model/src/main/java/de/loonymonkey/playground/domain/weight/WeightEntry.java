/**
 *
 */
package de.loonymonkey.playground.domain.weight;

import java.time.LocalDateTime;

import org.apache.commons.lang.Validate;

/**
 * @author Frank
 */
public class WeightEntry {
    private final LocalDateTime dateTime;
    private final float         weight;

    public WeightEntry(final LocalDateTime dateTime, final float weight) {
        Validate.notNull(dateTime, "|dateTime| must not be null!");
        Validate.isTrue(weight > 0, "|weight| must be non-negative!");
        this.dateTime = dateTime;
        this.weight = weight;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public float getWeight() {
        return this.weight;
    }
}
