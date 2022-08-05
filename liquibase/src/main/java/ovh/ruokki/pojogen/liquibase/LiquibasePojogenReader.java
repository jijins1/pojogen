package ovh.ruokki.pojogen.liquibase;

import liquibase.changelog.ChangeLogParameters;
import liquibase.exception.ChangeLogParseException;
import liquibase.exception.LiquibaseException;
import liquibase.parser.ChangeLogParserFactory;
import liquibase.resource.FileSystemResourceAccessor;
import ovh.ruokki.pojogen.model.PojogenReader;
import ovh.ruokki.pojogen.model.exception.ReadingException;

public class LiquibasePojogenReader implements PojogenReader {
    @Override
    public void read() throws ReadingException {
        try {

            FileSystemResourceAccessor fileSystemResourceAccessor = new FileSystemResourceAccessor();
            ChangeLogParserFactory.getInstance().getParser(
                    "this.changeLogFile", fileSystemResourceAccessor)
                    .parse("this.changeLogFile", new ChangeLogParameters(), fileSystemResourceAccessor);

        } catch (LiquibaseException e) {
            throw new ReadingException();
        }

    }
}
