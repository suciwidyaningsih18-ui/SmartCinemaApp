package smartcinemaapp;

public class TiketTidakDitemukanException extends Exception {
    public TiketTidakDitemukanException(String message) {
        super(message);
    }
}