package org.uva.sea.ql.ast.expressions.binary.arithmetic;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.binary.BinaryExpression;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.check.TypeEnvironment;

public abstract class BinaryArithmeticExpression extends BinaryExpression {
	protected BinaryArithmeticExpression(Expression leftHandSide, Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Numeric();
	}
}