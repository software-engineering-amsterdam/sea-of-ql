package org.uva.sea.ql.visitor.typechecking.errors;

import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.visitor.QLError;

public class UnsupportedTypeError extends QLError {

    private static final String ERROR_MESSAGE_TEMPLATE = "Error: variable on line %d of type %s was expected to be of type %s.";

    private final String expectedTypeName;
    private final String actualTypeName;

    public UnsupportedTypeError(int line, Type expectedType, Type actualType) {
        super(line);
        this.expectedTypeName = expectedType.getClass().getSimpleName();
        this.actualTypeName = actualType.getClass().getSimpleName();
    }

    @Override
    public String getErrorMessage() {
        return String.format(ERROR_MESSAGE_TEMPLATE, getLine(), expectedTypeName, actualTypeName);
    }
}
