package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;

public abstract class UnaryMathOperator extends UnaryExpr {

    protected UnaryMathOperator(Expr ex) {
        super(ex);
    }

}
