package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.Expression;

public abstract class UnaryBooleanOperator extends UnaryExpr implements
        Expression {

    protected UnaryBooleanOperator(Expr ex) {
        super(ex);
    }

}
