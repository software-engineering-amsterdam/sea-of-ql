package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;


public class IntegerPrimitive implements IntegerExpression {
	private final int value;
	
	public IntegerPrimitive(int n) {
		this.value = n;
	}
	
	public int getValue() {
		return this.value;
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
}
