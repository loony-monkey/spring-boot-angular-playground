/**
 *
 */
package de.loonymonkey.playground.weight.converter;

import de.loonymonkey.playground.weight.domain.WeightEntry;
import de.loonymonkey.playground.weight.json.FormattedWeightEntry;

/**
 * @author Frank
 */
public interface WeightConverter {
    public abstract FormattedWeightEntry toJsonable(final WeightEntry weightEntry);
}
