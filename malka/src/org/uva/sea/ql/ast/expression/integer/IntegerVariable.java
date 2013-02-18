package org.uva.sea.ql.ast.expression.integer;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.variable.Variable;

public class IntegerVariable implements IntegerExpression, Variable {
	
	private final Identifier id;
	
	public IntegerVariable(Identifier id) {
		this.id = id;
	}

	@Override
	public Identifier getID() {
		return id;
	}

}
