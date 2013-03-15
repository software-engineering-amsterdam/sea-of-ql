package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.operation.UnaryBooleanOperation;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class Not extends UnaryBooleanOperation {
	
	public Not(BooleanExpression operand) {
		super(operand);
	}

	@Override
	public void accept(Visitor visitor) throws VisitingException {
		visitor.visit(this);
	}

	@Override
	public boolean evaluate() {
		return operand.evaluate();
	}

}
