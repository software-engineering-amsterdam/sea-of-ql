package org.uva.sea.ql.ast.expression;



public abstract class UnaryExpression extends Expression {

	protected final Expression expr;
	
	public UnaryExpression(final Expression expr){
		this.expr = expr;
	}

	public Expression getExpr() {
		return expr;
	}
	
}