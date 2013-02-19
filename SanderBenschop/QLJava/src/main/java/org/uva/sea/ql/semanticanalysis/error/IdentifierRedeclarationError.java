package org.uva.sea.ql.semanticanalysis.error;

import org.uva.sea.ql.ast.SourceCodeInformation;

public class IdentifierRedeclarationError extends SemanticQLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: attempt to declare identifier with name '%s' on line '%d' column position '%d' failed, because it is already defined.";

    private final String identifierName;

    public IdentifierRedeclarationError(SourceCodeInformation sourceCodeInformation, String identifierName) {
        super(sourceCodeInformation);
        this.identifierName = identifierName;
    }

    @Override
    public String getErrorMessage() {
        int lineNumber = getSourceCodeInformation().getLineNumber(), columnPosition = getSourceCodeInformation().getColumnPosition();
        return String.format(ERROR_MESSAGE_TEMPLATE, identifierName, lineNumber, columnPosition);
    }
}
