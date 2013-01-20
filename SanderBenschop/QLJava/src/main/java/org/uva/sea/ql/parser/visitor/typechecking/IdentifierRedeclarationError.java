package org.uva.sea.ql.parser.visitor.typechecking;

import org.uva.sea.ql.parser.visitor.QLError;

public class IdentifierRedeclarationError extends QLError {

    private static final String TEMPLATE = "Error: attempt to declare identifier with name '%s' on line %d failed, because it is already defined.";

    private final String identifierName;

    public IdentifierRedeclarationError(int line, String identifierName) {
        super(line);
        this.identifierName = identifierName;
    }

    @Override
    public String getErrorMessage() {
        return String.format(TEMPLATE, identifierName, getLine());
    }
}
