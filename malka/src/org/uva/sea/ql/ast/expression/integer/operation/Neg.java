package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Neg extends UnaryArithmeticOperation {

	public Neg(IntegerExpression operand) {
		super(operand);
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}

}
