package org.uva.sea.ql.ast.expression;


public class Pos extends NumericUnaryExpression {
	
	public Pos(final Expression expr){
		super(expr);
	}
	
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
}
