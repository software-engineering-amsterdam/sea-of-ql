package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ASTVisitor;


public abstract class UnaryExpr extends Expression {

	protected final Expression expr;
	
	public UnaryExpr(final Expression expr){
		this.expr = expr;
	}

	public Expression getExpr() {
		return expr;
	}
	
}