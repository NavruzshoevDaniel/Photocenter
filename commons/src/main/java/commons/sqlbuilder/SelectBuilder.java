package commons.sqlbuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectBuilder extends AbstractSqlBuilder implements Cloneable, Serializable {

    private static final long serialVersionUID = 1;

    private boolean distinct;

    private final List<Object> columns = new ArrayList<>();

    private final List<String> tables = new ArrayList<>();

    private final List<String> joins = new ArrayList<>();

    private final List<String> leftJoins = new ArrayList<>();

    private final List<String> wheres = new ArrayList<>();

    private final List<String> groupBys = new ArrayList<>();

    private final List<String> havings = new ArrayList<>();

    private final List<SelectBuilder> unions = new ArrayList<>();

    private final List<String> orderBys = new ArrayList<>();

    private int limit = 0;

    private int offset = 0;

    private boolean forUpdate;

    private boolean noWait;

    public SelectBuilder() {

    }

    public SelectBuilder(String table) {
        tables.add(table);
    }

    protected SelectBuilder(SelectBuilder other) {

        this.distinct = other.distinct;
        this.forUpdate = other.forUpdate;
        this.noWait = other.noWait;

        for (Object column : other.columns) {
            if (column instanceof SubSelectBuilder) {
                this.columns.add(((SubSelectBuilder) column).clone());
            } else {
                this.columns.add(column);
            }
        }

        this.tables.addAll(other.tables);
        this.joins.addAll(other.joins);
        this.leftJoins.addAll(other.leftJoins);
        this.wheres.addAll(other.wheres);
        this.groupBys.addAll(other.groupBys);
        this.havings.addAll(other.havings);

        for (SelectBuilder sb : other.unions) {
            this.unions.add(sb.clone());
        }

        this.orderBys.addAll(other.orderBys);
    }


    public SelectBuilder and(String expr) {
        return where(expr);
    }

    public SelectBuilder column(String name) {
        columns.add(name);
        return this;
    }

    public SelectBuilder column(SubSelectBuilder subSelect) {
        columns.add(subSelect);
        return this;
    }

    public SelectBuilder column(String name, boolean groupBy) {
        columns.add(name);
        if (groupBy) {
            groupBys.add(name);
        }
        return this;
    }

    public SelectBuilder limit(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
        return this;
    }

    public SelectBuilder limit(int limit) {
        return limit(limit, 0);
    }

    @Override
    public SelectBuilder clone() {
        return new SelectBuilder(this);
    }

    public SelectBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public SelectBuilder forUpdate() {
        forUpdate = true;
        return this;
    }

    public SelectBuilder from(String table) {
        tables.add(table);
        return this;
    }

    public List<SelectBuilder> getUnions() {
        return unions;
    }

    public SelectBuilder groupBy(String expr) {
        groupBys.add(expr);
        return this;
    }

    public SelectBuilder having(String expr) {
        havings.add(expr);
        return this;
    }

    public SelectBuilder join(String join) {
        joins.add(join);
        return this;
    }

    public SelectBuilder leftJoin(String join) {
        leftJoins.add(join);
        return this;
    }

    public SelectBuilder noWait() {
        if (!forUpdate) {
            throw new RuntimeException("noWait without forUpdate cannot be called");
        }
        noWait = true;
        return this;
    }

    public SelectBuilder orderBy(String name) {
        orderBys.add(name);
        return this;
    }

    public SelectBuilder orderBy(String name, boolean ascending) {
        if (ascending) {
            orderBys.add(name + " asc");
        } else {
            orderBys.add(name + " desc");
        }
        return this;
    }

    @Override
    public String toString() {

        StringBuilder sql = new StringBuilder("select ");

        if (distinct) {
            sql.append("distinct ");
        }

        if (columns.isEmpty()) {
            sql.append("*");
        } else {
            appendList(sql, columns, "", ", ");
        }

        appendList(sql, tables, " from ", ", ");
        appendList(sql, joins, " join ", " join ");
        appendList(sql, leftJoins, " left join ", " left join ");
        appendList(sql, wheres, " where ", " and ");
        appendList(sql, groupBys, " group by ", ", ");
        appendList(sql, havings, " having ", " and ");
        appendList(sql, unions, " union ", " union ");
        appendList(sql, orderBys, " order by ", ", ");

        if (forUpdate) {
            sql.append(" for update");
            if (noWait) {
                sql.append(" nowait");
            }
        }

        if (limit > 0)
            sql.append(" limit ").append(limit);
        if (offset > 0)
            sql.append(", ").append(offset);

        return sql.toString();
    }

    public SelectBuilder union(SelectBuilder unionBuilder) {
        unions.add(unionBuilder);
        return this;
    }

    public SelectBuilder where(String expr) {
        wheres.add(expr);
        return this;
    }
}
