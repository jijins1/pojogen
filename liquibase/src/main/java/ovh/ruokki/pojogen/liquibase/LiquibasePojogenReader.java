package ovh.ruokki.pojogen.liquibase;

import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import liquibase.changelog.ChangeLogParameters;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.exception.LiquibaseException;
import liquibase.parser.ChangeLogParserFactory;
import liquibase.resource.FileSystemResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import ovh.ruokki.pojogen.data.Context;
import ovh.ruokki.pojogen.liquibase.change.LiquibaseChangeReader;
import ovh.ruokki.pojogen.model.PojogenReader;
import ovh.ruokki.pojogen.model.exception.ReadingException;

@Slf4j
public class LiquibasePojogenReader implements PojogenReader {
    private final String path;
    private final String directory;
    private final List<LiquibaseChangeReader<?>> liquibaseChangeReaders;

    public LiquibasePojogenReader(List<LiquibaseChangeReader<?>> liquibaseChangeReaders, String directory, String path) {
        this.path = path;
        this.directory = directory;
        this.liquibaseChangeReaders = liquibaseChangeReaders;
    }

    @Override
    public Context read() throws ReadingException {
        try {

            FileSystemResourceAccessor fileSystemResourceAccessor = new FileSystemResourceAccessor(
                    Paths.get(directory).toFile());
            DatabaseChangeLog parsed = ChangeLogParserFactory.getInstance().getParser(
                    this.path, fileSystemResourceAccessor)
                    .parse(this.path, new ChangeLogParameters(), fileSystemResourceAccessor);
            log.info("Change log  : {}", parsed);

            Context context = new Context();

            parsed.getChangeSets().stream().map(ChangeSet::getChanges)
                    .flatMap(Collection::stream)
                    .forEach((change) -> {
                        log.debug("Analyse {}, {}", change, change.getDescription());
                        liquibaseChangeReaders.stream()
                                .filter((liquibaseChangeReaders) -> liquibaseChangeReaders.getTypeHandled()
                                        .equals(change.getClass()))
                                .findFirst().ifPresent((reader) -> {
                                    log.debug("Add thing to context with {}", reader);
                                    reader.readUnchecked(change, context);
                                });
                    });
            return context;
        } catch (LiquibaseException e) {
            throw new ReadingException("Error during liquibase reading", e);
        }

    }
}
