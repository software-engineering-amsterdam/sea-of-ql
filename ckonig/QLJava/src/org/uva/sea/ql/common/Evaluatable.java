package org.uva.sea.ql.common;

public interface Evaluatable {
    public void accept(ExprVisitor visitor) throws VisitorException;
}
