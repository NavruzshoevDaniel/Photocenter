package commons.sessions.exceptions;

public class ConfigurationPropertyException extends RuntimeException{
    public ConfigurationPropertyException() {
        super();
    }

    public ConfigurationPropertyException(String message) {
        super(message);
    }

    public ConfigurationPropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationPropertyException(Throwable cause) {
        super(cause);
    }

    protected ConfigurationPropertyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
