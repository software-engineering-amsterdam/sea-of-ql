package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.Expression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class String extends AbstractAtom {

	private final java.lang.String value;

	public String(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getValue() {
		return value;
	}

	@Override
	public <T> T accept(Expression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractType typeOf(Environment environment) {
		return new org.uva.sea.ql.ast.type.String();
	}

	@Override
	public java.lang.String toString() {
		return java.lang.String.format("String (%s)", this.getValue());
	}

}
