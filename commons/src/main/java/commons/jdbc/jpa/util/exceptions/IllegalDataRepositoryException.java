package commons.jdbc.jpa.util.exceptions;

public class IllegalDataRepositoryException extends RuntimeException{
    public IllegalDataRepositoryException() {
    }

    public IllegalDataRepositoryException(String message) {
        super(message);
    }

    public IllegalDataRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalDataRepositoryException(Throwable cause) {
        super(cause);
    }
}
