package ovh.ruokki.pojogen.data.sql;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ovh.ruokki.pojogen.data.sql.Column;

@Getter
@Setter
@ToString
public class Table {
    
    private final List<Column> columns = new ArrayList<>();
    private final String name;

    public Table(String name) {
        this.name = name;
    }
}
