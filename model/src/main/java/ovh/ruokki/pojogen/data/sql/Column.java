package ovh.ruokki.pojogen.data.sql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ovh.ruokki.pojogen.data.Type;

@Setter
@Getter
@ToString
public class Column {
    String name;
    Type type;
}
