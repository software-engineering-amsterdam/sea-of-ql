package org.uva.sea.ql.visitor;

public abstract class QLError {

    private final int line;

    public QLError(int line) {
        this.line = line;
    }

    protected int getLine() {
        return line;
    }

    public abstract String getErrorMessage();
}
