package org.uva.sea.ql.ast.expressions.relational;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class LessThanExpression extends BinaryRelationalExpression {
	public LessThanExpression(Expression leftHandSide, Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}