package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.Evaluatable;

public abstract class BinaryBooleanOperator extends BinaryExpr implements
        Evaluatable {
    protected BinaryBooleanOperator(Expr l, Expr r) {
        super(l, r);
    }
}
