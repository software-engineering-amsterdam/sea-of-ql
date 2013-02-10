package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.ast.Valuable;

public abstract class Expression implements ASTNode, Natural, Valuable {

	public enum Nature {
		NUMERIC, BOOLEAN, TEXTUAL
	}

	protected Expression() {
		super();
	}
}
