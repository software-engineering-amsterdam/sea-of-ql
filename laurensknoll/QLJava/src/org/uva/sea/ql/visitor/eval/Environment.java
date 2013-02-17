package org.uva.sea.ql.visitor.eval;

import java.util.HashMap;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Environment {

	private class Binding {
		private final Widget widget;

		public Binding(Widget widget) {
			this.widget = widget;
		}

		public Widget getWidget() {
			return this.widget;
		}
	}

	private final Environment parent;
	private HashMap<Ident, Binding> bindings;

	public Environment() {
		this(null);
	}

	public Environment(Environment env) {
		this.parent = env;
		this.bindings = new HashMap<Ident, Binding>();
	}

	public Environment getParent() {
		return this.parent;
	}

	public void declare(Ident ident, Widget widget) {
		this.bindings.put(ident, new Binding(widget));
	}

	public AbstractValue valueOfIdent(Ident ident) {
		// Semantic validator guarantees that ident is defined.
		if (this.bindings.containsKey(ident)) {
			Binding binding = this.bindings.get(ident);
			return binding.getWidget().getValue();
		} else {
			return this.parent.valueOfIdent(ident);
		}
	}

	public Widget widgetOfIdent(Ident ident) {
		// Semantic validator guarantees that ident is defined.
		if (this.bindings.containsKey(ident)) {
			Binding binding = this.bindings.get(ident);
			return binding.getWidget();
		} else {
			return this.parent.widgetOfIdent(ident);
		}
	}
}
