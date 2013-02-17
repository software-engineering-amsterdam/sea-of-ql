package org.uva.sea.ql.common;

public interface Evaluatable {
    public void accept(EvaluationVisitor visitor) throws VisitorException;
}
