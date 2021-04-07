package commons.jdbc.jpa.util;

import commons.jdbc.jpa.annotations.Column;
import commons.jdbc.jpa.annotations.Id;
import commons.jdbc.jpa.annotations.Table;
import commons.jdbc.jpa.util.exceptions.IllegalDataRepositoryException;
import commons.sessions.SessionFactory;
import commons.util.Converter;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//TODO::refract code
@Slf4j
public final class RepositoryUtil {
    private static final String EQUALS_SYMBOL = "=";
    private static final String QUESTION_SYMBOL = "?";
    private static final String SELECT_ALL_TEMPLATE = "SELECT * FROM %s";
    private static final String DELETE_TEMPLATE = "DELETE FROM %s WHERE %s";
    private static final String UPDATE_TEMPLATE = "UPDATE %s SET %s WHERE %s";
    private static final String INSERT_TEMPLATE = "INSERT INTO %s VALUES (%s)";
    private static final String AND = " AND ";
    private static final String COMA = ", ";

    private RepositoryUtil() {
    }

    public static <T> void update(T data) throws IllegalAccessException, SQLException {
        Objects.requireNonNull(data);
        final Class<?> clazz = data.getClass();
        final StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            stringBuilder.append(getFieldColumnName(fields[i]));
            stringBuilder.append(EQUALS_SYMBOL);
            stringBuilder.append(QUESTION_SYMBOL);
            if (i != fields.length - 1) {
                stringBuilder.append(COMA);
            }
        }
        String query = String.format(UPDATE_TEMPLATE, getTableName(clazz),
                stringBuilder.toString(), createWhereIds(data));
        try (PreparedStatement statement = SessionFactory.getInstance().prepareStatement(query)) {
            prepareStatement(data, fields, statement);
            log.info(query);
            statement.executeUpdate();
        }
    }


    public static <T> void create(T data) throws SQLException, IllegalAccessException {
        Objects.requireNonNull(data);
        final Class<?> clazz = data.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fields.length - 1; i++) {
            stringBuilder.append(QUESTION_SYMBOL).append(COMA);
        }
        stringBuilder.append(QUESTION_SYMBOL);
        final String insertQuery =
                String.format(INSERT_TEMPLATE, getTableName(clazz), stringBuilder.toString());
        try (final PreparedStatement statement =
                     SessionFactory.getInstance().prepareStatement(insertQuery)) {
            prepareStatement(data, fields, statement);
            statement.execute();
        }
    }

    private static <T> void prepareStatement(T data, Field[] fields, PreparedStatement statement)
            throws SQLException, IllegalAccessException {
        for (int i = 1; i <= fields.length; i++) {
            fields[i - 1].setAccessible(true);
            if (fields[i - 1].get(data) == Date.class) {
                statement.setDate(i, (Date) fields[i - 1].get(data));
            } else {
                statement.setObject(i, fields[i - 1].get(data));
            }
        }
    }

    public static <T> void deleteById(T data) throws IllegalAccessException, SQLException {
        final Class<?> clazz = data.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final long idCount = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Id.class))
                .count();
        if (idCount > 0) {
            try (final Statement statement = SessionFactory.getInstance().createStatement()) {
                String query = String.format(DELETE_TEMPLATE, getTableName(clazz),
                        createWhereIds(data));
                log.info(query);
                statement.execute(query);
            }
        } else {
            throw new IllegalDataRepositoryException("No id in the table:" + getTableName(clazz));
        }
    }

    private static <T> String createWhereIds(T data) throws IllegalAccessException {
        final Field[] fields = data.getClass().getDeclaredFields();
        final long idCount = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Id.class))
                .count();
        StringBuilder stringBuilder = new StringBuilder();
        int iteratorIndex = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                //TODO:: convert boolean fields
                field.setAccessible(true);
                stringBuilder.append(getFieldColumnName(field))
                        .append(EQUALS_SYMBOL)
                        .append(field.get(data));
                iteratorIndex++;
                if (iteratorIndex != idCount) {
                    stringBuilder.append(AND);
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String getFieldColumnName(Field field) {
        if (!field.isAnnotationPresent(Column.class)) {
            return Converter.camelToSnake(field.getName());
        } else {
            return field.getAnnotation(Column.class).columnName();
        }
    }

    private static <T> String getTableName(Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalDataRepositoryException("It is not annotated by @Table");
        } else {
            String tableName = clazz.getAnnotation(Table.class).tableName();
            if (tableName.isEmpty()) {
                return Converter.camelToSnake(clazz.getSimpleName() + "s");
            } else {
                return tableName;
            }
        }
    }


    public static <T> List<T> getAll(Class<T> repositoryClass) throws SQLException {
        Objects.requireNonNull(repositoryClass);
        return selectQuery(repositoryClass, String.format(SELECT_ALL_TEMPLATE,
                getTableName(repositoryClass)));
    }

    public static <T> List<T> selectQuery(Class<T> type, String query) throws SQLException {
        Objects.requireNonNull(type);
        Objects.requireNonNull(query);
        List<T> list = new ArrayList<>();

        try (Statement stmt = SessionFactory.getInstance().createStatement()) {
            try (ResultSet rst = stmt.executeQuery(query)) {
                while (rst.next()) {
                    T t = type.newInstance();
                    loadResultSetIntoObject(rst, t);
                    list.add(t);
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalDataRepositoryException("Unable to get the records: "
                    + e.getMessage(), e);
        }

        return list;
    }

    public static void loadResultSetIntoObject(ResultSet rst, Object object)
            throws IllegalArgumentException, IllegalAccessException, SQLException {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            log.info(field.getName());
            Object jdbcValue = convert(rst, getFieldColumnName(field), fieldType);
            field.set(object, jdbcValue);
        }
    }


    public static <T> List<String> getColumns(Class<T> clazz) throws SQLException {
        final ArrayList<String> columnNames = new ArrayList<>();
        try (Statement statement = SessionFactory.getInstance().createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format(SELECT_ALL_TEMPLATE, getTableName(clazz)));
            final ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnNames.add(metaData.getColumnName(i));
            }
        }
        log.info(columnNames.toString());
        return columnNames;
    }

    private static Object convert(ResultSet resultSet,
                                  String columnName,
                                  Class<?> fieldType) throws SQLException {
        if (fieldType == int.class) {
            return resultSet.getInt(columnName);
        } else if (fieldType == long.class) {
            return resultSet.getLong(columnName);
        } else if (fieldType == double.class) {
            return resultSet.getDouble(columnName);
        } else if (fieldType == float.class) {
            return resultSet.getFloat(columnName);
        } else if (fieldType == boolean.class) {
            return resultSet.getInt(columnName) == 1;
        } else if (fieldType == byte.class) {
            return resultSet.getByte(columnName);
        } else if (fieldType == char.class) {
            return Character.class;
        } else if (fieldType == Date.class) {
            return resultSet.getDate(columnName);
        } else {
            return resultSet.getObject(columnName);
        }
    }
}