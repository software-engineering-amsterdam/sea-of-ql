package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.EvaluationVisitor;
import org.uva.sea.ql.common.VisitorException;

public class Sub extends BinaryMathOperator {
    public static final String STR = "-";

    public Sub(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public void accept(EvaluationVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }
}
