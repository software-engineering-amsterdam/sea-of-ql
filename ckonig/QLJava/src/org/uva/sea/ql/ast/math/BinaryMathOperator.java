package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;

public abstract class BinaryMathOperator extends BinaryExpr implements
        Evaluatable {
    protected BinaryMathOperator(Expr l, Expr r) {
        super(l, r);
    }
}
