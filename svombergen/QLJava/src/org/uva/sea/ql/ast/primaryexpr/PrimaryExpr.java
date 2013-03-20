package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public abstract class PrimaryExpr extends Expr {
	
	public abstract void accept(IExpressionVisitor v);
}
