package org.uva.sea.ql.ast.expression;


public class Not extends UnaryExpression {
	
	public Not(final Expression expr){
		super(expr);
	}
	
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
}
