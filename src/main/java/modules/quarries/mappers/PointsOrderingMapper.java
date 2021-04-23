package modules.quarries.mappers;

import lombok.Getter;

@Getter
public enum PointsOrderingMapper implements IQueryMapper {
    OUTLET_TYPE("Тип торговой точки", "NAME");
    private final String viewPresentation;
    private final String sqlExpression;


    PointsOrderingMapper(String viewPresentation, String sqlExpression) {
        this.viewPresentation = viewPresentation;
        this.sqlExpression = sqlExpression;
    }
}
