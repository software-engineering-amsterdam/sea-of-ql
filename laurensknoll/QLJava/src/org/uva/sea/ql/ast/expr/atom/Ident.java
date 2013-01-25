package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.Expression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class Ident extends AbstractAtom {

	private final java.lang.String name;

	public Ident(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return name;
	}

	@Override
	public <T> T accept(Expression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractType typeOf(Environment environment) {
		if (!environment.exists(this)) {
			return null;
		} else {
			return environment.typeOfIdent(this);
		}
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ident)) {
			return false;
		}

		Ident ident = (Ident) obj;
		return this.name.equals(ident.getName());
	}
}
