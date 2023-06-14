package live.cloverescape.graphqldgs.tool;

import graphql.language.SelectionSet;
import graphql.schema.DataFetchingFieldSelectionSet;
import graphql.schema.SelectedField;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SQL 语句构建器，根据 Graphql 传递的 selection set 动态构建
 * @author weibb
 */
@Slf4j
public class SQLQueryBuilder {

    public static final String SELECT = "SELECT";
    public static final String USER_TABLE = "USER";

    public static String buildSqlFromSelectionSet(String baseSql, String tableName, DataFetchingFieldSelectionSet selectionSet) {
        assert tableName != null;
        StringBuilder sqlBuilder = new StringBuilder(baseSql);
        List<String> selectFields = parseSelectionSet(selectionSet);
        assert !selectFields.isEmpty();

        List<String> aliasedFields = new ArrayList<>();
        String tableAlias = tableName.substring(0, 1).toLowerCase();
        for (String field : selectFields) {
            // 在字段名前添加别名前缀
            aliasedFields.add(tableAlias + "." + field + " " + field);
        }

        sqlBuilder.append(" ").append(String.join(", ", aliasedFields));
        sqlBuilder.append(" FROM ").append(tableName).append(" ").append(tableAlias);
        log.info("Current Query Sql: " + sqlBuilder.toString());
        return sqlBuilder.toString();
    }

    private static List<String> parseSelectionSet(DataFetchingFieldSelectionSet selectionSet) {
        List<String> selectFields = new ArrayList<>();
        for (SelectedField field : selectionSet.getFields()) {
            selectFields.add(field.getName());
            if (field.getSelectionSet() != null) {
                List<String> nestedFields = parseSelectionSet(field.getSelectionSet());
                selectFields.addAll(nestedFields);
            }
        }
        return selectFields;
    }
}
