package ovh.ruokki.pojogen.liquibase;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import ovh.ruokki.pojogen.model.exception.ReadingException;

public class LiquibasePojogenReaderTest {
     @Test
     public void itShouldChargeDataset() throws ReadingException{
        Path path = Paths.get( "changelog","changelog.simple.xml");
        LiquibasePojogenReader liquibasePojogenReader = new LiquibasePojogenReader("changelog/changelog.simple.xml");
        liquibasePojogenReader.read();
     }
}
