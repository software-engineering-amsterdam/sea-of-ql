package org.uva.sea.ql.formLoader;

public class FormLoaderException extends RuntimeException {
    public FormLoaderException(Exception exception) {
        super(exception);
    }

    public FormLoaderException(String message) {
        super(message);
    }

    public FormLoaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
