package modules.quarries.dto;

import commons.sqlbuilder.Operation;
import lombok.Getter;
import modules.quarries.mappers.IQueryMapper;

@Getter
public class SearchCriteria {
    private final IQueryMapper key;
    private final Operation operation;
    private final Object value;

    public SearchCriteria(IQueryMapper key, Operation operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }
}
