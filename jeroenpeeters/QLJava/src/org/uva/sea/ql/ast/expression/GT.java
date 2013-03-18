package org.uva.sea.ql.ast.expression;


public class GT extends BooleanBinaryExpression {
	
	public GT(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
}