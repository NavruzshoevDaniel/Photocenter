package commons.sqlbuilder.predicates;

import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public final class PredicateUtil {
    private static final String SPACE = " ";
    private static final String AND = "AND";
    private static final String OR = "OR";

    public static Predicate and(Predicate... predicates) {
        return join(AND, Arrays.asList(predicates));
    }

    public static Predicate and(List<Predicate> predicates) {
        return join(AND, predicates);
    }

    public static Predicate equals(String expr, Object value) {
        return () -> String.format("%s = %s", expr, value);
    }

    public static Predicate equalsStrings(String expr, Object value) {
        return () -> String.format("%s = %s", expr, toSqlString(value.toString()));
    }

    public static Predicate in(String expr, List<?> values) {
        return () -> {
            StringBuilder sb = new StringBuilder();
            sb.append(expr).append(" in (");

            boolean first = true;
            for (Object value : values) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(value);
                first = false;
            }

            sb.append(")");
            return sb.toString();
        };
    }


    public static Predicate in(String expr, Object... values) {
        return in(expr, Arrays.asList(values));
    }

    private static Predicate join(String joinWord, List<Predicate> preds) {
        return () -> {
            StringBuilder sb = new StringBuilder().append("(");
            boolean first = true;
            for (Predicate p : preds) {
                if (!first) {
                    sb.append(SPACE).append(joinWord).append(SPACE);
                }
                sb.append(p.toSql());
                first = false;
            }
            return sb.append(")").toString();
        };
    }

    private static Predicate join(String joinWord, Object... elements) {
        return () -> {
            StringBuilder sb = new StringBuilder().append("(");
            boolean first = true;
            for (Object p : elements) {
                if (!first) {
                    sb.append(SPACE).append(joinWord).append(SPACE);
                }
                sb.append(p);
                first = false;
            }
            return sb.append(")").toString();
        };
    }

    public static Predicate notEquals(String expr, Object value) {
        return () -> String.format("%s <> %s", expr, value);
    }


    public static Predicate not(Predicate childPredicate) {
        return () -> "not (" + childPredicate.toSql() + ")";
    }

    public static Predicate or(Predicate... predicates) {
        return join(OR, Arrays.asList(predicates));
    }

    public static Predicate or(List<Predicate> predicates) {
        return join(OR, predicates);
    }


    public static Predicate isNull(String expr) {
        return () -> String.format("%s is null", expr);
    }


    public static Predicate isNotNull(String expr) {
        return () -> String.format("%s is not null", expr);
    }

    public static Predicate more(String expr, Object value) {
        return () -> String.format("%s > %s", expr, value);
    }

    public static Predicate greaterOrEquals(String expr, Object value) {
        return () -> String.format("%s >= %s", expr, value);
    }

    public static Predicate less(String expr, Object value) {
        return () -> String.format("%s < %s", expr, value);
    }

    public static Predicate lessOrEquals(String expr, Object value) {
        return () -> String.format("%s <= %s", expr, value);
    }

    public static Predicate like(String expr, Object value) {
        return () -> String.format("%s like '%s'", expr, value);
    }

    public static Predicate equalsIgnoreCase(String expr, Object value) {
        String sqlString = toSqlString(value.toString());
        return like(upper(expr), upper(sqlString));
    }

    private static String toSqlString(String string) {
        return String.format("'%s'", string);
    }

    private static String upper(String expr) {
        return String.format("UPPER(%s)", expr);
    }

    public static Predicate contains(String expr, Object value) {
        String sqlString = toSqlString(value.toString());
        return like(upper(expr), "%" + upper(sqlString) + "%");
    }

    public static Predicate after(String expr, Date after) {
        return more(expr, after.toString());
    }

    public static Predicate before(String expr, Date before) {
        return less(expr, before.toString());
    }

    public static Predicate between(String expr, Date after, Date before) {
        String afterSqlString = toSqlString(after.toString());
        String beforeSqlString = toSqlString(before.toString());
        return () -> String.format("%s BETWEEN %s %s %s", expr, afterSqlString, AND, beforeSqlString);
    }
}
