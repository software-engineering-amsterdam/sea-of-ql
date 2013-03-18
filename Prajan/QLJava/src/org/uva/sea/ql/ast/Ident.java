package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;
import org.uva.sea.ql.visitor.Value;

public class Ident extends Value {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		if (typeEnv.containsKey(this)) {
			return typeEnv.get(this);
		}
		return new TypeError("Undefined Ident " + name);
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o instanceof Ident)
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
