package modules.quarries.dto;

import commons.sqlbuilder.Operations;
import lombok.Getter;

@Getter
public class SearchCriteria {
    private final String key;
    private final Operations operation;
    private final Object value;

    public SearchCriteria(String key, Operations operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }
}
