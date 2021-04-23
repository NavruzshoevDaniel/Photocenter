package commons.sqlbuilder;

import java.util.ArrayList;
import java.util.List;

public class CriteriaBuilder extends AbstractSqlBuilder {
    private final boolean whereExists = true;
    private final List<String> wheres = new ArrayList<>();

    public CriteriaBuilder where(String expr) {
        wheres.add(expr);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sql = new StringBuilder();
        if (whereExists) {
            appendList(sql, wheres, " where ", " and ");
        } else {
            appendList(sql, wheres, " and ", " and ");
        }

        return sql.toString();
    }
}
