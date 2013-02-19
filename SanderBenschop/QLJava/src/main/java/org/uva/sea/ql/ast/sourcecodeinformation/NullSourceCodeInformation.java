package org.uva.sea.ql.ast.sourcecodeinformation;

/**
 * Null implementation of SourceCodeInformation interface, used for situations in which no source code is present
 * such as for user input.
 */
public class NullSourceCodeInformation implements SourceCodeInformation {

    private static final String MESSAGE = "No source code information is present.";

    @Override
    public int getLineNumber() {
        throw new UnsupportedOperationException(MESSAGE);
    }

    @Override
    public int getColumnPosition() {
        throw new UnsupportedOperationException(MESSAGE);
    }
}
