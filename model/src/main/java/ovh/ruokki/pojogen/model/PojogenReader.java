package ovh.ruokki.pojogen.model;

import ovh.ruokki.pojogen.model.exception.ReadingException;

/**
 * Read file to transform it to the model object
 */
public interface PojogenReader {
    void read() throws ReadingException;
}