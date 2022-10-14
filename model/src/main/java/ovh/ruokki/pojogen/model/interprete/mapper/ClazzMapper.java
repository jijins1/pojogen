package ovh.ruokki.pojogen.model.interprete.mapper;

import ovh.ruokki.pojogen.data.Type;
import ovh.ruokki.pojogen.data.java.Clazz;
import ovh.ruokki.pojogen.data.java.Field;
import ovh.ruokki.pojogen.data.sql.Column;
import ovh.ruokki.pojogen.data.sql.Table;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.google.common.base.CaseFormat;

@Mapper()
public interface ClazzMapper {
    @Mapping(target = "thePackage", ignore = true)
    @Mapping(source = "name", target = "name", qualifiedByName = "useUpperCamelCase")
    @Mapping(source = "columns", target = "fields")
    Clazz toClazz(Table table);
    
    Field toField(Column column);
    default Clazz mapType(Type type){
        if(type.equals(Type.string())){
            return Clazz.STRING;
        }else {
            return null;
        }
    }
    @Named("useUpperCamelCase")
    static String useUpperCamelCase(String name) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
    }
    
}
