package ovh.ruokki.pojogen.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Field {
    String name;
    Type type;
}