package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class Or extends BinaryBooleanOperator {
    private static final String STR = "||";

    public Or(Expr left, Expr right) {
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
