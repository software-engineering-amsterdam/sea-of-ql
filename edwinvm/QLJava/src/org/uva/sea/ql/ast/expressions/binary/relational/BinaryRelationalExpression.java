package org.uva.sea.ql.ast.expressions.binary.relational;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.binary.BinaryExpression;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.parser.TypeEnvironment;

public abstract class BinaryRelationalExpression extends BinaryExpression {
	protected BinaryRelationalExpression(Expression leftHandSide, Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new Bool();
	}
}