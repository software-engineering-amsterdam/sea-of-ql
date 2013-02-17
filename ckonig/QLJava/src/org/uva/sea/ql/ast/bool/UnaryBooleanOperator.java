package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.common.Evaluatable;

public abstract class UnaryBooleanOperator extends UnaryExpr implements
        Evaluatable {

    public UnaryBooleanOperator(Expr ex) {
        super(ex);
    }

}
