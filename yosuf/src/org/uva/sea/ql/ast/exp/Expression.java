package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;

public abstract class Expression implements ASTNode, Natural {

	protected Expression() {
		super();
	}

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
}
