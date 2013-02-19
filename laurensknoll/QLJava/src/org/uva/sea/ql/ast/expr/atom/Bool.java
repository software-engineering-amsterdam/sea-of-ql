package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.IExpression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class Bool extends AbstractAtom {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(IExpression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractType typeOf(Environment environment) {
		return new org.uva.sea.ql.ast.type.Bool();
	}

	@Override
	public java.lang.String toString() {
		return java.lang.String.format("Boolean (%b)", this.getValue());
	}

}
