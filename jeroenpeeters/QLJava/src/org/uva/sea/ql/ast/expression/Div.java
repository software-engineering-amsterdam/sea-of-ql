package org.uva.sea.ql.ast.expression;


public class Div extends NumericBinaryExpression {
	
	public Div(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
}
