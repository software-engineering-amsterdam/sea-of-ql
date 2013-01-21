package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class String extends AbstractAtom {

	private final java.lang.String value;

	public String(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getValue() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

}
