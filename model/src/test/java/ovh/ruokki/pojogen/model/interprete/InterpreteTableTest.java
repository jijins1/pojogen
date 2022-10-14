package ovh.ruokki.pojogen.model.interprete;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import ovh.ruokki.pojogen.data.java.Clazz;
import ovh.ruokki.pojogen.data.sql.Column;
import ovh.ruokki.pojogen.data.Context;
import ovh.ruokki.pojogen.data.sql.Table;
import ovh.ruokki.pojogen.data.Type;
import ovh.ruokki.pojogen.model.exception.ReadingException;

public class InterpreteTableTest {

   InterpreteTable interprete = new InterpreteTable();

   @Test
   public void itShouldCreateClassFromTable() throws ReadingException {
      var context = new Context();
      var table  = new Table("event");
      var column  = new Column();
      column.setName("a");
      column.setType(Type.string());
      table.getColumns().add(column);

      context.getTables().add(table);

      interprete.interprete(context);

      Assertions.assertThat(context.getClazz()).hasSize(1).allSatisfy((clazz) -> {
         Assertions.assertThat(clazz.getName()).isEqualTo("Event");
         Assertions.assertThat(clazz.getFields())
               .hasSize(1)
               .anySatisfy(field -> {
                  Assertions.assertThat(field.getName()).isEqualTo("a");
                  Assertions.assertThat(field.getType()).isEqualTo(Clazz.STRING);
               });

      });
}

}
