/**
 *
 */
package de.loonymonkey.playground.weight.converter.impl;

import org.springframework.stereotype.Component;

import de.loonymonkey.playground.weight.converter.WeightConverter;
import de.loonymonkey.playground.weight.domain.WeightEntry;
import de.loonymonkey.playground.weight.json.FormattedWeightEntry;

/**
 * TODO: What about using MapStruct for this purpose?
 *
 * @author Frank
 */
@Component
public class WeightConverterImpl implements WeightConverter {
    public WeightConverterImpl() {
    }

    @Override
    public FormattedWeightEntry toJsonable(final WeightEntry weightEntry) {
        return new FormattedWeightEntry(weightEntry.getDate().toString(), weightEntry.getWeight());
    }
}
