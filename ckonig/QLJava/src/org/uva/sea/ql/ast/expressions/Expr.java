package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.common.ExpressionVisitor;
import org.uva.sea.ql.common.QLException;


public abstract class Expr  {
    public Expr(){
    }
    public abstract void accept(ExpressionVisitor visitor) throws QLException;
}
