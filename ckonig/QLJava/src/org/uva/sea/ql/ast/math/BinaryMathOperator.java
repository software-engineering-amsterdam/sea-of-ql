package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;

public abstract class BinaryMathOperator extends BinaryExpr {
    protected BinaryMathOperator(Expr l, Expr r) {
        super(l, r);
    }
}
