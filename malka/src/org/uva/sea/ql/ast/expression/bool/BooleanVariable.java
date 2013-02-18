package org.uva.sea.ql.ast.expression.bool;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.variable.Variable;

public class BooleanVariable extends BooleanExpression
implements Variable {
	
	private final Identifier id;
	
	public BooleanVariable(Identifier id) {
		this.id = id;
	}

	@Override
	public Identifier getID() {
		return id;
	}

}
