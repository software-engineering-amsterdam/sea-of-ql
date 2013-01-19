package org.uva.sea.ql.parser.visitor.typechecking;

import org.uva.sea.ql.parser.visitor.QLError;

public class TypeCheckingError extends QLError {

    private static final String TEMPLATE = "Error: variable on line %d of type %s was expected to be reduceable to %s.";

    private final String expectedTypeName;
    private final String actualTypeName;

    public TypeCheckingError(int line, String expectedTypeName, String actualTypeName) {
        super(line);
        this.expectedTypeName = expectedTypeName;
        this.actualTypeName = actualTypeName;
    }

    public String getErrorMessage() {
        return String.format(TEMPLATE, getLine(), actualTypeName, expectedTypeName);
    }
}
