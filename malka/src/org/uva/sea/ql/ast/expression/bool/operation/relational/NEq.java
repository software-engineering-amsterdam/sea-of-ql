package org.uva.sea.ql.ast.expression.bool.operation.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class NEq extends BinaryRelationalOperation {

	public NEq(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public boolean evaluate() {
		return (left_operand.compareTo(right_operand)) != 0;
	}
	
}
