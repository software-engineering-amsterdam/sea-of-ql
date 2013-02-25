package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;

public abstract class BinaryBooleanOperator extends BinaryExpr {
    protected BinaryBooleanOperator(Expr l, Expr r) {
        super(l, r);
    }
}
