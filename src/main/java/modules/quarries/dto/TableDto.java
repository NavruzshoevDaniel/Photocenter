package modules.quarries.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TableDto {
    private final List<String> columns;
    private final List<RowDto> rows;

    public TableDto(List<String> columns, List<RowDto> rows) {
        this.columns = columns;
        this.rows = rows;
    }
}
