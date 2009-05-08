package liquibase.change;

import liquibase.database.Database;
import liquibase.statement.DeleteStatement;
import liquibase.statement.SqlStatement;
import liquibase.util.StringUtils;

public class DeleteDataChange extends AbstractChange {

    private String schemaName;
    private String tableName;
    private String whereClause;

    public DeleteDataChange() {
        super("delete", "Delete Data");
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = StringUtils.trimToNull(schemaName);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

    public SqlStatement[] generateStatements(Database database) {

        DeleteStatement statement = new DeleteStatement(getSchemaName() == null ? database.getDefaultSchemaName() : getSchemaName(), getTableName());

        statement.setWhereClause(whereClause);

        return new SqlStatement[]{
                statement
        };
    }

    public String getConfirmationMessage() {
        return "Data deleted from " + getTableName();
    }

}
