package org.uva.sea.ql.ast.expressions.binary.logical;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class LogicallyEquivalentExpression extends BinaryLogicalExpression {
	public LogicallyEquivalentExpression(Expression leftHandSide, Expression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}