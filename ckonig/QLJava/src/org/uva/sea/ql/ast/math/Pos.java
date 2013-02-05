package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExprVisitor;
import org.uva.sea.ql.common.VisitorException;

public class Pos extends UnaryMathOperator {
    public static final String STR = "+";

    public Pos(Expr ex) {
        super(ex);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public void accept(ExprVisitor visitor) throws VisitorException {
        visitor.visit(this);
    }

}
