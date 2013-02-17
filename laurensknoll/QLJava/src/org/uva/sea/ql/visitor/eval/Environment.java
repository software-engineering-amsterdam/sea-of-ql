package org.uva.sea.ql.visitor.eval;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;

public class Environment {

	private class Binding extends Observable implements Observer {
		private final Widget widget;
		private AbstractValue value;

		public Binding(Widget widget) {
			this.widget = widget;
			this.widget.addObserver(this);

			this.value = this.widget.getValue();
		}

		public Widget getWidget() {
			return this.widget;
		}

		public AbstractValue getValue() {
			return this.value;
		}

		public void setValue(AbstractValue value) {
			// This will trigger the observer pattern
			this.widget.setValue(value);
		}

		@Override
		public void update(Observable observerable, Object arg) {
			// Read value from GUI
			this.value = this.widget.getValue();

			// And propagate to Environment.
			this.setChanged();
			this.notifyObservers();
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

	public void addObserver(Ident ident, Observer observer) {
		if (this.bindings.containsKey(ident)) {
			Binding binding = this.bindings.get(ident);
			binding.addObserver(observer);
		} else {
			this.parent.addObserver(ident, observer);
		}
	}

	public AbstractValue getValue(Ident ident) {
		// Semantic validator guarantees that ident is defined.
		if (this.bindings.containsKey(ident)) {
			Binding binding = this.bindings.get(ident);
			return binding.getValue();
		} else {
			return this.parent.getValue(ident);
		}
	}

	public void setValue(Ident ident, AbstractValue value) {
		// Semantic validator guarantees that ident is defined.
		if (this.bindings.containsKey(ident)) {
			Binding binding = this.bindings.get(ident);
			binding.setValue(value);
		} else {
			this.parent.setValue(ident, value);
		}
	}

	public void setReadOnly(Ident ident, boolean isReadOnly) {
		if (this.bindings.containsKey(ident)) {
			Binding binding = this.bindings.get(ident);
			binding.getWidget().setReadOnly(isReadOnly);
		} else {
			this.parent.setReadOnly(ident, isReadOnly);
		}
	}

}
