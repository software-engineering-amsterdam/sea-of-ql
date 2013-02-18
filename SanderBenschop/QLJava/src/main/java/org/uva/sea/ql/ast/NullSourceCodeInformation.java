package org.uva.sea.ql.ast;

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
