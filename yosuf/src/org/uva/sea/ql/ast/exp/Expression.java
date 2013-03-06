package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Type;

public abstract class Expression implements ASTNode {

	protected Expression() {
		super();
	}

	public abstract Type getType();

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
}