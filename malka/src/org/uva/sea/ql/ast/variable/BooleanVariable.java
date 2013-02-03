package org.uva.sea.ql.ast.variable;

import org.uva.sea.ql.ast.BooleanExpression;
import org.uva.sea.ql.ast.Identifier;

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
