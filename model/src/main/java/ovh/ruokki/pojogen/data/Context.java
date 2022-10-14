package ovh.ruokki.pojogen.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import ovh.ruokki.pojogen.data.java.Clazz;
import ovh.ruokki.pojogen.data.sql.Table;

@Getter
@Setter
public class Context {
    private final List<Table> tables = new ArrayList<>();
    private final List<Clazz> clazz = new ArrayList<>();

}
