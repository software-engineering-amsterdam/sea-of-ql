package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitorException;


public class BooleanPrimitive implements BooleanExpression {
	
	private final boolean value;
	
	public BooleanPrimitive(boolean bool) {
		this.value = bool;
	}

	public boolean getValue() {
		return this.value;
	}

	@Override
	public void accept(Visitor visitor) throws VisitorException {
		visitor.visit(this);
	}
	
}
