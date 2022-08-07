package ovh.ruokki.pojogen.model.interprete.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import com.google.common.base.CaseFormat;

import ovh.ruokki.pojogen.data.Clazz;
import ovh.ruokki.pojogen.data.Table;

@Mapper()
public interface ClazzMapper {
    @Mapping(source = "name", target = "name", qualifiedByName = "useUpperCamelCase")
    @Mapping(source = "columns", target ="fields")
    public Clazz toClazz(Table table);
    @Named("useUpperCamelCase")
    public static String useUpperCamelCase(String name){
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
    }

}
