package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.Visitor;
import org.uva.sea.ql.ast.expression.Expression;

public class Not extends UnaryExpression {
	public Not(Expression operand) {
		super(operand);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
