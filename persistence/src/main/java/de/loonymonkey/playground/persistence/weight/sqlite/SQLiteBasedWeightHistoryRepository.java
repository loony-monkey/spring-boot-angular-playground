/**
 *
 */
package de.loonymonkey.playground.persistence.weight.sqlite;

import java.util.List;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void setup() {
        // this.jdbcTemplate.execute("drop table if exists weight");
        // this.jdbcTemplate.execute("create table weight (date TEXT, weight FLOAT)");
        // this.jdbcTemplate.execute("insert into weight values ('2015-06-06', 99.7)");
        // this.jdbcTemplate.execute("insert into weight values ('2015-06-13', 100)");
    }

    @Override
    public List<WeightEntry> getAllEntries() {
        return this.jdbcTemplate.query("select date, weight from weight order by date", new WeightRowExtractor());
    }
}
