package org.uva.sea.ql.ast.expressions.arithmetic;

import org.uva.sea.ql.ast.expressions.BinaryExpression;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.types.Numeric;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.check.TypeEnvironment;

public abstract class BinaryArithmeticalExpression extends BinaryExpression {
	protected BinaryArithmeticalExpression(Expression leftHandSide, Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Numeric();
	}
}