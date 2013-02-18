package org.uva.sea.ql.ast;

public final class SourceCodeInformationImpl implements SourceCodeInformation {

    private final int lineNumber;
    private final int columnPosition;

    public SourceCodeInformationImpl(int lineNumber, int columnPosition) {
        this.lineNumber = lineNumber;
        this.columnPosition = columnPosition;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public int getColumnPosition() {
        return columnPosition;
    }
}