package org.uva.sea.ql.core.dom.operators.relational;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.operators.RelationalOperator;

public class LEq extends RelationalOperator {

	public LEq(Expression lhs, Expression rhs) {
		super(lhs,rhs);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);		
	}
}
