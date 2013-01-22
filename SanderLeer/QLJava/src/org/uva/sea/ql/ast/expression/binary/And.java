package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.expression.Expression;

public class And extends BinaryExpression {
	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
