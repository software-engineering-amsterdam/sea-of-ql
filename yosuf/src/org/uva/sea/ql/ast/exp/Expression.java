package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.value.Value;

public abstract class Expression implements ASTNode {

	protected Expression() {
		super();
	}

	public abstract Value evaluate();
}
