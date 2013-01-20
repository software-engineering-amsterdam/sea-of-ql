package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.visitor.Context;
import org.uva.sea.ql.visitor.Visitor;

public class IntLiteral extends Value {

	private final int value;

	public IntLiteral(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(Visitor visitor, Context context) {
		 visitor.visit(this, context);
	}


	

}
