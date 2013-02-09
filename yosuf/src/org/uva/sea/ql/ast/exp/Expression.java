package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;

public abstract class Expression implements ASTNode, Natural {

	public enum Nature {
		NUMERIC, BOOLEAN, TEXTUAL
	}

	protected Expression() {
		super();
	}
}
