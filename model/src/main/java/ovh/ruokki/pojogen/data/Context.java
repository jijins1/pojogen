package ovh.ruokki.pojogen.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Context {
    private final List<Table> tables = new ArrayList<>();

}
