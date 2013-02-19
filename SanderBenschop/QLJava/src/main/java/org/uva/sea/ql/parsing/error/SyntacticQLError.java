package org.uva.sea.ql.parsing.error;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.general.QLError;

public class SyntacticQLError implements QLError {

    private static final String SYNTAX_ERROR_MESSAGE_TEMPLATE = "Syntactic error on line %d column position %d: %s";

    private final String antlrErrorMessage;
    private final int lineNumber;
    private final int columnPosition;

    public SyntacticQLError(int lineNumber, int columnPosition, String antlrErrorMessage) {
        this.antlrErrorMessage = antlrErrorMessage;
        this.lineNumber = lineNumber;
        this.columnPosition = columnPosition;
    }

    public SyntacticQLError(RecognitionException recognitionException, String antlrErrorMessage) {
        this(recognitionException.line, recognitionException.charPositionInLine, antlrErrorMessage);
    }

    @Override
    public String getErrorMessage() {
        return String.format(SYNTAX_ERROR_MESSAGE_TEMPLATE, lineNumber, columnPosition, antlrErrorMessage);
    }
}
