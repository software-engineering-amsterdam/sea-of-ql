package org.uva.sea.ql.interpreter.valueParser;

public class ValueParserException extends RuntimeException {

    public ValueParserException(String message) {
        super(message);
    }

    public ValueParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
