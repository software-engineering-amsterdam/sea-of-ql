package org.uva.sea.ql.visitor.eval;

import java.util.HashMap;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Environment {

	private final Environment parent;
	private HashMap<Ident, AbstractValue> bindings;

	public Environment() {
		this(null);
	}

	public Environment(Environment env) {
		this.parent = env;
		this.bindings = new HashMap<Ident, AbstractValue>();
	}

	public Environment getParent() {
		return this.parent;
	}

	public void declare(Ident ident, AbstractValue value) {
		this.bindings.put(ident, value);
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

	public AbstractValue typeOfIdent(Ident ident) {
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
