package org.uva.sea.ql.valuePersister;

public class ValuePersisterException extends RuntimeException {
    public ValuePersisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValuePersisterException(Throwable cause) {
        super(cause);
    }
}
