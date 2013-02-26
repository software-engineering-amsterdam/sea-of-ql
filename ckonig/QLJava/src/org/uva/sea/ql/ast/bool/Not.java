package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class Not extends UnaryBooleanOperator {
    private static final String STR = "!";

    public Not(Expr ex) {
        super(ex);
    }

    @Override
    public final String toString() {
        return STR;
    }

    @Override
    public final void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }
}
