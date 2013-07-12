package org.uva.sea.ql.ast.primaryexpr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public abstract class PrimaryExpr extends Expr {
	
	@Override
	public abstract <T> T accept(IExpressionVisitor<T> v);
	
}
