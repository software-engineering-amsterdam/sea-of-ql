package org.uva.sea.ql.ast.variable;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.IntegerExpression;

public class IntegerVariable extends IntegerExpression
implements Variable {
	
	private final Identifier id;
	
	public IntegerVariable(Identifier id) {
		this.id = id;
	}

	@Override
	public Identifier getID() {
		return id;
	}

}
