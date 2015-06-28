/**
 *
 */
package de.loonymonkey.playground.weight;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.MappingStrategy;

import de.loonymonkey.playground.persistence.weight.api.WeightHistoryRepository;
import de.loonymonkey.playground.tools.csv.IntrospectionBasedMapper;
import de.loonymonkey.playground.weight.converter.WeightConverter;
import de.loonymonkey.playground.weight.domain.MutableWeightEntry;
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

    @RequestMapping(value = "/data", method = RequestMethod.GET, produces = "text/csv")
    public String data() {
        final List<MutableWeightEntry> historicalData = historicalData().stream().map(entry -> new MutableWeightEntry(entry)).collect(Collectors.toList());

        final ByteArrayOutputStream memoryStream = new ByteArrayOutputStream();
        final Writer writer = new OutputStreamWriter(memoryStream);
        try (CSVWriter csvWriter = new CSVWriter(writer, ',', CSVWriter.NO_QUOTE_CHARACTER)) {
            final BeanToCsv<MutableWeightEntry> beanExporter = new BeanToCsv<>();
            final MappingStrategy<MutableWeightEntry> mappingStrategy = new IntrospectionBasedMapper<>(MutableWeightEntry.class);
            beanExporter.write(mappingStrategy, csvWriter, historicalData);
        } catch (final IOException e) {
            // TODO: return a proper error code
            return "";
        }

        return memoryStream.toString();
    }

    private final List<WeightEntry> historicalData() {
        return this.repository.getAllEntries();
    }
}
