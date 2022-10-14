package ovh.ruokki.pojogen.data;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Type {
    private static final Type STRING = new Type("String");
    private static final Type LONG = new Type("Long");
    
    String name;

    public static Type string() {
        return STRING;
    }
    public static Type longType() {
        return LONG;
    }

}


