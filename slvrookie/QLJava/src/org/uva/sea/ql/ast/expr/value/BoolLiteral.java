package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class BoolLiteral extends Value {

	private final boolean value;

	public BoolLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor, Context context) {
		visitor.visit(this, context);
		
	}


}
