package ua.hillel.springsecurityapp.exception;

public class InconsistencyException extends Exception {
    public InconsistencyException(String message) {
        super(message);
    }

    public InconsistencyException(String message, Throwable cause) {
        super(message, cause);
    }
}
