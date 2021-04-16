package modules.quarries.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class RowDto {
    private final List<Object> columns;

    public RowDto(List<Object> columns) {
        this.columns = columns;
    }
}
