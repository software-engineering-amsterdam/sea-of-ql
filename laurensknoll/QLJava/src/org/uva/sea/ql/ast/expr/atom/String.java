package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class String extends AbstractAtom {

	private final java.lang.String value;

	public String(java.lang.String value) {
		// Strip quotes, no length check needed due to
		// successfully parsing of grammar.
		this.value = value.substring(1, value.length() - 1);
	}

	public java.lang.String getValue() {
		return value;
	}

	@Override
	public <T> T accept(IExpression<T> visitor) {
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
