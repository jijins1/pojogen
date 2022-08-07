package ovh.ruokki.pojogen.liquibase;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import ovh.ruokki.pojogen.data.Context;
import ovh.ruokki.pojogen.data.Type;
import ovh.ruokki.pojogen.liquibase.change.LiquibaseChangeReaderCreateTable;
import ovh.ruokki.pojogen.liquibase.type.TypeChooser;
import ovh.ruokki.pojogen.model.exception.ReadingException;

public class LiquibasePojogenReaderTest {
   @Test
   public void itShouldChargeDataset() throws ReadingException {
      Path path = Paths.get("changelog", "changelog.simple.xml");
      TypeChooser typeChooser = new TypeChooser();
      LiquibasePojogenReader liquibasePojogenReader = new LiquibasePojogenReader(
            List.of(new LiquibaseChangeReaderCreateTable(typeChooser)), "src/test/resources",
            "changelog/changelog.simple.xml");
      Context context = liquibasePojogenReader.read();
      Assertions.assertThat(context.getTables()).hasSize(1)
            .allSatisfy((table) -> {
               Assertions.assertThat(table.getName()).isEqualTo("event");
               Assertions.assertThat(table.getColumns())
                     .hasSize(2)
                     .anySatisfy(column -> {
                        Assertions.assertThat(column.getName()).isEqualTo("id");
                        Assertions.assertThat(column.getType()).isEqualTo(Type.longType());
                     }).anySatisfy(column -> {
                        Assertions.assertThat(column.getName()).isEqualTo("resource");
                        Assertions.assertThat(column.getType()).isEqualTo(Type.string());
                     });

            });
   }
}
