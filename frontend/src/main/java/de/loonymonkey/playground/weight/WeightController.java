/**
 *
 */
package de.loonymonkey.playground.weight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableList;

import de.loonymonkey.playground.weight.converter.WeightConverter;
import de.loonymonkey.playground.weight.domain.WeightEntry;
import de.loonymonkey.playground.weight.json.FormattedWeightEntry;

/**
 * @author Frank
 */
@RestController
@RequestMapping("/weight")
public class WeightController {
    private final WeightConverter weightConverter;

    @Autowired
    public WeightController(final WeightConverter weightConverter) {
        this.weightConverter = weightConverter;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<FormattedWeightEntry> completeHistory() {
        List<WeightEntry> historicalData = historicalData();
        return historicalData.stream().map(data -> this.weightConverter.toJsonable(data)).collect(Collectors.toList());
    }

    private final List<WeightEntry> historicalData() {
        // TODO: read some real data from somewhere...
        return ImmutableList.<WeightEntry> builder().add(
                new WeightEntry(LocalDate.now(), 100)
                ).build();
    }
}
