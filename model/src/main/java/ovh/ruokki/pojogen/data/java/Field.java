package ovh.ruokki.pojogen.data.java;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ovh.ruokki.pojogen.data.Type;

@Setter
@Getter
@ToString
@Builder
public class Field {
    private final String name;
    private final Clazz type;
    private final Set<Clazz> annotations = new HashSet<>();
}
