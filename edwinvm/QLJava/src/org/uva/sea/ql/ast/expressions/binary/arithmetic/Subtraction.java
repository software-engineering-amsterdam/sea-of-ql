package org.uva.sea.ql.ast.expressions.binary.arithmetic;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class Subtraction extends BinaryArithmeticExpression {
	public Subtraction(Expression leftHandSide, Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}