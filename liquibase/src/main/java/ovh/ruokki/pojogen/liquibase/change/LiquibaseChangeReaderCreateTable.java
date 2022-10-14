package ovh.ruokki.pojogen.liquibase.change;

import liquibase.change.core.CreateTableChange;
import lombok.extern.slf4j.Slf4j;
import ovh.ruokki.pojogen.data.sql.Column;
import ovh.ruokki.pojogen.data.Context;
import ovh.ruokki.pojogen.data.sql.Table;
import ovh.ruokki.pojogen.liquibase.type.TypeChooser;

@Slf4j
public class LiquibaseChangeReaderCreateTable implements LiquibaseChangeReader<CreateTableChange> {

    private final TypeChooser typeChooser;

    public LiquibaseChangeReaderCreateTable(TypeChooser typeChooser) {
        this.typeChooser = typeChooser;
    }

    @Override
    public void read(CreateTableChange change, Context context) {
        Table table = new Table(change.getTableName());

        change.getColumns().forEach(columnConfig -> {
            var column = new Column();
            column.setName(columnConfig.getName());
            column.setType(typeChooser.chooseType(columnConfig.getType()));
            table.getColumns().add(column);
        });

        log.debug("Table {} added", table);
        context.getTables().add(table);
    }

    @Override
    public Class<CreateTableChange> getTypeHandled() {
        return CreateTableChange.class;
    }

}
