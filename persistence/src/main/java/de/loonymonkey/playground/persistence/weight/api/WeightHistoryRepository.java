/**
 *
 */
package de.loonymonkey.playground.persistence.weight.api;

import java.util.List;

import de.loonymonkey.playground.weight.domain.WeightEntry;

/**
 * @author Frank
 */
public interface WeightHistoryRepository {
    public abstract List<WeightEntry> getAllEntries();
}
