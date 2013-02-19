package org.uva.sea.ql.ast;

public class SourceCodeInformation {

    private final int lineNumber;
    private final int columnPosition;

    public SourceCodeInformation(int lineNumber, int columnPosition) {
        this.lineNumber = lineNumber;
        this.columnPosition = columnPosition;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnPosition() {
        return columnPosition;
    }
}
