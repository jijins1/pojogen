package ovh.ruokki.pojogen.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Clazz {
    
    private final List<Field> fields = new ArrayList<>();
    private final String name;

    public Clazz(String name) {
        this.name = name;
    }
}
