package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;

public abstract class UnaryBooleanOperator extends UnaryExpr {

    protected UnaryBooleanOperator(Expr ex) {
        super(ex);
    }

}
