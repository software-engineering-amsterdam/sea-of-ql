package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Ident extends AbstractAtom {

	private final java.lang.String value;

	public Ident(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getName() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

}
