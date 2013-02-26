package org.uva.sea.ql.ast.operators.conditional;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.operators.ConditionalOperator;

public class And extends ConditionalOperator {

	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}
