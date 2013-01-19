package org.uva.sea.ql.parser.visitor;

public abstract class QLError {

    private final int line;

    public QLError(int line) {
        this.line = line;
    }

    protected int getLine() {
        return line;
    }
}
