/**
 *
 */
package de.loonymonkey.playground.persistence.weight.sqlite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import de.loonymonkey.playground.persistence.weight.api.WeightHistoryRepository;
import de.loonymonkey.playground.weight.domain.WeightEntry;

/**
 * @author Frank
 */
@Component
public class SQLiteBasedWeightHistoryRepository implements WeightHistoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<WeightEntry> getAllEntries() {
        return this.jdbcTemplate.query("select date, weight from weight order by date desc", new WeightRowExtractor());
    }
}
