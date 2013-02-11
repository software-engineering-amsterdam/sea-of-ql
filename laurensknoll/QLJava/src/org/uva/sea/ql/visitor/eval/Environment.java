package org.uva.sea.ql.visitor.eval;

import java.util.HashMap;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Environment {

	private final Environment parent;
	private HashMap<Ident, IdentContext> bindings;

	public Environment() {
		this(null);
	}

	public Environment(Environment env) {
		this.parent = env;
		this.bindings = new HashMap<Ident, IdentContext>();
	}

	public Environment getParent() {
		return this.parent;
	}

	public void declare(Ident ident, Widget widget) {
		this.bindings.put(ident, new IdentContext(widget));
	}

	public AbstractValue valueOfIdent(Ident ident) {
		// Semantic validator guarantees that ident is defined.
		if (this.bindings.containsKey(ident)) {
			return this.bindings.get(ident).getValue();
		} else {
			return this.parent.valueOfIdent(ident);
		}
	}

}
