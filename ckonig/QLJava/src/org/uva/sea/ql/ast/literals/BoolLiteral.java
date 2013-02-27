package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;

public class BoolLiteral extends Expr {
    private boolean value;

    public BoolLiteral(Boolean b) {
        this.value = b;
    }

    public final boolean getValue() {
        return this.value;
    }

    @Override
    public final void accept(ExpressionVisitor visitor) throws QLException {
        visitor.visit(this);
    }
}
