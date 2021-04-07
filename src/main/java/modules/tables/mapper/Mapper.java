package modules.tables.mapper;

import java.sql.Date;
import java.util.Map;

public class Mapper {
    private final Map<String, Object> stringObjectMap;

    public Mapper(Map<String, Object> stringObjectMap) {
        this.stringObjectMap = stringObjectMap;
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(String.valueOf(stringObjectMap.get(key)));
    }

    public int getInteger(String key) {
        return Integer.parseInt(String.valueOf(stringObjectMap.get(key)));
    }

    public double getDouble(String key) {
        return Double.parseDouble(String.valueOf(stringObjectMap.get(key)));
    }

    public String getString(String key) {
        return String.valueOf(stringObjectMap.get(key));
    }

    public Date getDate(String key) {
        return Date.valueOf(String.valueOf(stringObjectMap.get(key)));
    }
}
