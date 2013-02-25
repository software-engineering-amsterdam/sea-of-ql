package org.uva.sea.ql.core.dom.operators.conditional;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.operators.ConditionalOperator;

public class And extends ConditionalOperator {

	public And(Expression lhs, Expression rhs) {
	super(lhs,rhs);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}
}