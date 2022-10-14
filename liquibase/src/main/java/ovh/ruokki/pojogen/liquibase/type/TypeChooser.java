package ovh.ruokki.pojogen.liquibase.type;

import lombok.extern.slf4j.Slf4j;
import ovh.ruokki.pojogen.data.Type;
@Slf4j
public class TypeChooser {
    public Type chooseType(String typeColumn){
        if(typeColumn.toLowerCase().contains("varchar")){
            return Type.string();
        }else if(typeColumn.equalsIgnoreCase("bigint")){
            return Type.longType();
        }else{
            log.warn("Not type found for {}", typeColumn);
            return Type.string();
        }
    }
}
