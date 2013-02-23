package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class Pos extends UnaryMathOperator {
    private static final String STR = "+";

    public Pos(Expr ex) {
        super(ex);
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
