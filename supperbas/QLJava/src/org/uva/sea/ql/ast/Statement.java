package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.statement.Visitor;

public abstract class Statement implements ASTNode {

	public abstract <T> T accept(Visitor<T> visitor);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
