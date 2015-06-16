/**
 *
 */
package de.loonymonkey.playground.weight;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.loonymonkey.playground.persistence.weight.api.WeightHistoryRepository;
import de.loonymonkey.playground.weight.converter.WeightConverter;
import de.loonymonkey.playground.weight.domain.WeightEntry;
import de.loonymonkey.playground.weight.json.FormattedWeightEntry;

/**
 * @author Frank
 */
@RestController
@RequestMapping("/weight")
public class WeightService {
    private final WeightConverter         weightConverter;
    private final WeightHistoryRepository repository;

    @Autowired
    public WeightService(final WeightConverter weightConverter, final WeightHistoryRepository repository) {
        Validate.notNull(weightConverter, "|weightConverter| must not be null!");
        Validate.notNull(repository, "|repository| must not be null!");
        this.weightConverter = weightConverter;
        this.repository = repository;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<FormattedWeightEntry> completeHistory() {
        final List<WeightEntry> historicalData = historicalData();
        return historicalData.stream().map(data -> this.weightConverter.toJsonable(data)).collect(Collectors.toList());
    }

    private final List<WeightEntry> historicalData() {
        return this.repository.getAllEntries();
    }
}
