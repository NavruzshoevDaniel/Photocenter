package modules.quarries.mappers;

import lombok.Getter;

@Getter
public enum PointsOrderingQueryMapper1 implements IQueryMapper {
    OUTLET_TYPE("Outlet type", "OUTLET_TYPES.ID");
    private final String viewPresentation;
    private final String sqlExpression;

    PointsOrderingQueryMapper1(String viewPresentation, String sqlExpression) {
        this.viewPresentation = viewPresentation;
        this.sqlExpression = sqlExpression;
    }
}
