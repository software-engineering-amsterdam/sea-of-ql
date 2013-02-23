package org.uva.sea.ql.ast.expressions.binary.logical;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;

public class Or extends BinaryLogicalExpression {
	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}