package ovh.ruokki.pojogen.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
