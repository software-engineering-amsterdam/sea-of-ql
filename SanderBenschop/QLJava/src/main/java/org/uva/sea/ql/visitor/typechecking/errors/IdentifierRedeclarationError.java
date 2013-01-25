package org.uva.sea.ql.visitor.typechecking.errors;

import org.uva.sea.ql.visitor.QLError;

public class IdentifierRedeclarationError extends QLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: attempt to declare identifier with name '%s' on line %d failed, because it is already defined.";

    private final String identifierName;

    public IdentifierRedeclarationError(int line, String identifierName) {
        super(line);
        this.identifierName = identifierName;
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE_TEMPLATE, identifierName, getLine());
    }
}
