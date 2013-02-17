package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.variable.Variable;

public class StringVariable implements Variable {

	private final Identifier id;

	public StringVariable(Identifier id) {
		this.id = id;
	}
	
	@Override
	public Identifier getID() {
		return id;
	}

}
