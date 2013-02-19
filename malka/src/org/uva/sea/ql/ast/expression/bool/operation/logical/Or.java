package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;

public class Or extends BinaryBooleanOperation {

	public Or(BooleanExpression left, BooleanExpression right) {
		super(left, right);
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}

}
