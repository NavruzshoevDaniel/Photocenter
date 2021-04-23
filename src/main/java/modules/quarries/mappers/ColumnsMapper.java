package modules.quarries.mappers;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ColumnsMapper {
    OUTLET_ID("Номер торговой точки"),
    TYPE("Тип"),
    ADDRESS("Адрес"),
    RELATED_OUTLET_ID("Номер вышестоящего филиала");

    private final String columnName;

    ColumnsMapper(String columnName) {
        this.columnName = columnName;
    }

    private static final Map<String, String> BY_COLUMN = new HashMap<>();

    static {
        for (ColumnsMapper mapper : ColumnsMapper.values()) {
            BY_COLUMN.put(mapper.name(), mapper.getColumnName());
        }
    }

    public static String mapColumn(String string) {
        return BY_COLUMN.get(string);
    }
}
