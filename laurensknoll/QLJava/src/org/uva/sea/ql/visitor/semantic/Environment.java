package org.uva.sea.ql.visitor.semantic;

import java.util.HashMap;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.type.AbstractType;

public class Environment {

	private final Environment parent;
	private HashMap<Ident, AbstractType> bindings;

	public Environment() {
		this(null);
	}

	public Environment(Environment env) {
		this.parent = env;
		this.bindings = new HashMap<Ident, AbstractType>();
	}

	public Environment getParent() {
		return this.parent;
	}

	public void declare(Ident ident, AbstractType type) {
		this.bindings.put(ident, type);
	}

	public boolean exists(Ident ident) {
		if (this.bindings.containsKey(ident)) {
			return true;
		}

		if (this.parent != null) {
			return this.parent.exists(ident);
		}

		return false;
	}

	public AbstractType typeOfIdent(Ident ident) {
		if (this.bindings.containsKey(ident)) {
			return this.bindings.get(ident);
		}

		if (this.parent != null) {
			return this.parent.typeOfIdent(ident);
		}

		throw new IllegalArgumentException(
				"Ident is not defined. Use exists before calling typeOfIdent.");
	}

}
