package org.uva.sea.ql.semanticanalysis.error;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;

public class UnsupportedTypeError extends SemanticQLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: variable on line '%d' column position '%d' of type %s was expected to be of type %s.";

    private final Type expectedType;
    private final Type actualType;

    public UnsupportedTypeError(SourceCodeInformation sourceCodeInformation, Type expectedType, Type actualType) {
        super(sourceCodeInformation);
        this.expectedType = expectedType;
        this.actualType = actualType;
    }

    @Override
    public String getErrorMessage() {
        int lineNumber = getSourceCodeInformation().getLineNumber(), columnPosition = getSourceCodeInformation().getColumnPosition();
        return String.format(ERROR_MESSAGE_TEMPLATE, lineNumber, columnPosition, actualType.getObjectLiteralSimpleClassName(), expectedType.getObjectLiteralSimpleClassName());
    }
}
