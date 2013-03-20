package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.IExpressionVisitor;

public abstract class UnaryExpr extends Expr {
	protected Expr expression;
	
	public UnaryExpr(Expr result) {
		expression = result;
	}
	
	public Expr getExpr() {
		return expression;
	}
	
	@Override
	public abstract void accept(IExpressionVisitor v);
	
	@Override
	public boolean isNumeric() {
		return expression.isNumeric();
	}
	
	@Override
	public boolean isBoolean() {
		return expression.isBoolean();
	}
	
	@Override
	public String toString() {
		return this.getType() + expression;
	}
	
}
