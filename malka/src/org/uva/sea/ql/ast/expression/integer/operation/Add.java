package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Add extends BinaryIntegerOperation {

	public Add(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}

}
