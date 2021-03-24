package modules.tables.service;

import modules.tables.repository.ITablesRepository;
import modules.tables.repository.TablesRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TablesNamesService implements ITablesNamesService {
    private static final String WORD_DELIMITER = "_";
    private static final String SPACE_CHARACTER = " ";
    private final ITablesRepository tablesRepository = new TablesRepository();

    @Override
    public List<String> getAllTablesNames() {
        return tablesRepository.getAllTables()
                .stream()
                .map(tableName -> tableName.replace(WORD_DELIMITER, SPACE_CHARACTER))
                .collect(Collectors.toList());
    }
}
