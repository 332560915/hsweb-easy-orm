package org.hswebframework.ezorm.rdb.supports.h2;

import org.hswebframework.ezorm.rdb.metadata.RDBSchemaMetadata;
import org.hswebframework.ezorm.rdb.supports.commons.RDBTableMetadataParser;


public class H2TableMetadataParser extends RDBTableMetadataParser {
    private static final String TABLE_META_SQL =
            "SELECT column_name AS \"name\"," +
                    "type_name AS \"data_type\"," +
                    "character_maximum_length as \"data_length\"," +
                    "numeric_precision as \"data_precision\"," +
                    "numeric_scale as \"data_scale\"," +
                    "case when is_nullable='YES' then 0 else 1 end as \"not-null\"," +
                    "remarks as \"comment\" " +
                    "FROM information_schema.columns " +
                    "WHERE table_name = upper(#{table}) and table_schema=#{schema}";
    private static final String TABLE_COMMENT_SQL =
            "SELECT remarks as \"comment\" " +
                    "FROM information_schema.tables WHERE table_type='TABLE' and table_name=upper(#{table}) and table_schema=#{schema}";
    private static final String ALL_TABLE_SQL =
            "SELECT table_name as \"name\" " +
                    "FROM information_schema.tables where table_type='TABLE' and table_schema=#{schema}";

    private static final String TABLE_EXISTS_SQL = "SELECT count(1) as \"total\" FROM information_schema.columns " +
            "WHERE table_name = upper(#{table}) and table_schema=#{schema}";

    public H2TableMetadataParser(RDBSchemaMetadata schema) {
        super(schema);
    }

    @Override
    protected String getTableMetaSql(String name) {
        return TABLE_META_SQL;
    }

    @Override
    protected String getTableCommentSql(String name) {
        return TABLE_COMMENT_SQL;
    }

    @Override
    protected String getAllTableSql() {
        return ALL_TABLE_SQL;
    }

    @Override
    public String getTableExistsSql() {
        return TABLE_EXISTS_SQL;
    }
}
