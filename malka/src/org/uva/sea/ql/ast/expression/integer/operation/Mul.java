package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class Mul extends BinaryIntegerOperation {

	public Mul(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public int evaluate() {
		return left_operand.evaluate() * right_operand.evaluate();
	}
}
