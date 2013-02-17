package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.QLException;
import org.uva.sea.ql.common.interfaces.EvaluationVisitor;

public class Mul extends BinaryMathOperator {
    private static final String STR = "*";

    public Mul(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws QLException {
        visitor.visit(this);
    }

}
