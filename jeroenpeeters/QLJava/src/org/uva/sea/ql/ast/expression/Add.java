package org.uva.sea.ql.ast.expression;

public class Add extends NumericBinaryExpression {
	
	public Add(final Expression lhs, final Expression rhs){
		super(lhs, rhs);
	}
	
	public <T> T accept(final ExpressionVisitor<T> v){
		return v.visit(this);
	}
	
}