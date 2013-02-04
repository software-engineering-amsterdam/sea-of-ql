package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public abstract class Expression implements ASTNode {

	public enum Nature {
		NUMERIC, BOOLEAN, TEXTUAL
	}

	protected Expression() {
		super();
	}

	public abstract <T> T accept(ExpressionVisitor<T> visitor);

	public abstract Nature getNature();
}
