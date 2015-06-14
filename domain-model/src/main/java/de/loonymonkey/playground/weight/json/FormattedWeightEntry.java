/**
 *
 */
package de.loonymonkey.playground.weight.json;

import org.apache.commons.lang.Validate;

import de.loonymonkey.playground.weight.domain.WeightEntry;

/**
 * A UI representation of the {@link WeightEntry}.
 * <p>
 * Not sure this is a good idea at all. Probably, we should simple return the {@link WeightEntry} in our REST service, and let the JS code do all that
 * formatting stuff. <br/>
 * But for now, since I am much more comfortable with Java than with JS code, we do that stuff here. Not my most important problem, at the moment :).
 * </p>
 * 
 * @author Frank
 */
public class FormattedWeightEntry {
    private final String date;
    private final float  weight;

    public FormattedWeightEntry(final String date, final float weight) {
        Validate.notNull(date, "|date| must not be null!");
        Validate.isTrue(weight > 0, "|weight| must be non-negative!");
        this.date = date;
        this.weight = weight;
    }

    public String getDate() {
        return this.date;
    }

    public float getWeight() {
        return this.weight;
    }
}
