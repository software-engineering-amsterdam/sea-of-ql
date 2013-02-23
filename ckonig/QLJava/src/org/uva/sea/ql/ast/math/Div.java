package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class Div extends BinaryMathOperator {
    private static final String STR = "/";

    public Div(Expr left, Expr right) {
        super(left, right);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }

}
