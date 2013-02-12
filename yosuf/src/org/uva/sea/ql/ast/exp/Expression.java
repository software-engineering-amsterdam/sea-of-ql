package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Natural;
import org.uva.sea.ql.visitor.ValuableVisitor;

public abstract class Expression<T> implements ASTNode, Natural {

	public enum Nature {
		NUMERIC, BOOLEAN, TEXTUAL
	}

	protected Expression() {
		super();
	}

	public abstract T accept(ValuableVisitor visitor);
}
