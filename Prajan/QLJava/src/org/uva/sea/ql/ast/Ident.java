package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.gen.TypeError;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;

public class Ident extends Expr {

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

	/*
	 * @Override public boolean equals(Object obj) { if (obj == null) return
	 * false; if (this.getClass() != obj.getClass()) return false; return true;
	 * }
	 * 
	 * @Override public int hashCode() { return name.toString().hashCode(); }
	 */

}
