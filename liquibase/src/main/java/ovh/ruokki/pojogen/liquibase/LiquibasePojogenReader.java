package ovh.ruokki.pojogen.liquibase;

import java.nio.file.Paths;

import liquibase.changelog.ChangeLogParameters;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.exception.LiquibaseException;
import liquibase.parser.ChangeLogParserFactory;
import liquibase.resource.FileSystemResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import ovh.ruokki.pojogen.model.PojogenReader;
import ovh.ruokki.pojogen.model.exception.ReadingException;

@Slf4j
public class LiquibasePojogenReader implements PojogenReader {
    private final String path;

    public LiquibasePojogenReader(String path) {
        this.path = path;
    }

    @Override
    public void read() throws ReadingException {
        try {

            FileSystemResourceAccessor fileSystemResourceAccessor = new FileSystemResourceAccessor(
                    Paths.get("src", "test", "resources").toFile());
            DatabaseChangeLog parsed = ChangeLogParserFactory.getInstance().getParser(
                    this.path, fileSystemResourceAccessor)
                    .parse(this.path, new ChangeLogParameters(), fileSystemResourceAccessor);
            log.info("Change log  : {}", parsed);
        } catch (LiquibaseException e) {
            throw new ReadingException("Error during liquibase reading", e);
        }

    }
}
