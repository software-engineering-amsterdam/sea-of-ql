package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class Or extends BinaryLogicalOperation {

	public Or(BooleanExpression left, BooleanExpression right) {
		super(left, right);
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}
	
	@Override
	public boolean evaluate() {
		return ((BooleanExpression)left_operand).evaluate() || ((BooleanExpression)right_operand).evaluate();
	}

}
