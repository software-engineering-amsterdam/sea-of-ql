package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.Expression;

public class Bool extends AbstractAtom {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(Expression<T> visitor) {
		return visitor.visit(this);
	}

}