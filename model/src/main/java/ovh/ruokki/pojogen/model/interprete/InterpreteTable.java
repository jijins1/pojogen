package ovh.ruokki.pojogen.model.interprete;

import java.util.List;

import org.mapstruct.factory.Mappers;

import lombok.extern.slf4j.Slf4j;
import ovh.ruokki.pojogen.data.Clazz;
import ovh.ruokki.pojogen.data.Context;
import ovh.ruokki.pojogen.model.interprete.mapper.ClazzMapper;

/**
 * Use information in {@link Context} to create class in context
 */
@Slf4j
public class InterpreteTable {
    ClazzMapper mapper = Mappers.getMapper(ClazzMapper.class);

    public void interprete(Context context) {
        List<Clazz> listClazzs = context.getTables().stream().map(table -> {
            Clazz clazz = mapper.toClazz(table);
            log.debug("Add class {}", clazz);
            return clazz;
        }).toList();
        context.getClazz().addAll(listClazzs);
    }

}
