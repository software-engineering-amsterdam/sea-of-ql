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

	public AbstractValue valueOfIdent(Ident ident) {
		// Semantic validator guarantees that ident is defined.
		if (this.bindings.containsKey(ident)) {
			return this.bindings.get(ident);
		} else {
			return this.parent.valueOfIdent(ident);
		}
	}

}
