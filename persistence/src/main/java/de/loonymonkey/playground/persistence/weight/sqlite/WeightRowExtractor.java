/**
 *
 */
package de.loonymonkey.playground.persistence.weight.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import de.loonymonkey.playground.weight.domain.WeightEntry;

/**
 * a {@link RowMapper} extracting a {@link WeightEntry} from our SQLite database.
 *
 * @author Frank
 */
public class WeightRowExtractor implements RowMapper<WeightEntry> {

    @Override
    public WeightEntry mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final LocalDate date = LocalDate.parse(rs.getString(1));
        final float weight = rs.getFloat(2);
        return new WeightEntry(date, weight);
    }
}
