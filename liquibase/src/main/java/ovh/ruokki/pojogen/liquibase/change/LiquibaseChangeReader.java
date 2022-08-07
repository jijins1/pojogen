package ovh.ruokki.pojogen.liquibase.change;

import liquibase.change.Change;
import ovh.ruokki.pojogen.data.Context;

public interface LiquibaseChangeReader<T extends Change> {

    void read(T change, Context context);

    Class<T> getTypeHandled();

    default void readUnchecked(Change change, Context context) {
        this.read((T) change, context);
    }

}
