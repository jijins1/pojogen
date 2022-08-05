package ovh.ruokki.pojogen.model.exception;

public class ReadingException extends Exception {

    public ReadingException(String string, Exception e) {
        super(string, e);
    }

}
