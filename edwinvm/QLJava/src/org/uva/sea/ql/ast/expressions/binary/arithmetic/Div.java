package org.uva.sea.ql.ast.expressions.binary.arithmetic;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class Div extends BinaryArithmeticExpression {
	public Div(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}