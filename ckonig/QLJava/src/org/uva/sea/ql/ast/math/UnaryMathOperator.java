package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;

public abstract class UnaryMathOperator extends UnaryExpr implements
        Evaluatable {

    public UnaryMathOperator(Expr ex) {
        super(ex);
    }

}
