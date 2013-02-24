package org.uva.sea.ql.visitor.eval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.visitor.eval.ui.Widget;
import org.uva.sea.ql.visitor.eval.value.AbstractValue;
import org.uva.sea.ql.visitor.eval.value.Undefined;

public class Environment extends Observable implements Observer {

	private class Binding extends Observable implements Observer {
		private final Widget widget;
		private AbstractValue value;

		public Binding(Widget widget, AbstractValue value) {
			this.widget = widget;
			this.widget.addObserver(this);

			this.value = value;
		}

		public AbstractValue getValue() {
			return this.value;
		}

		public void setValue(AbstractValue value) {
			this.value = value;

			// Update GUI (This will trigger the observer pattern).
			this.widget.setValue(value);
		}

		@Override
		public void update(Observable observerable, Object arg) {
			// Read value from GUI
			this.value = this.widget.getValue();

			this.setChanged();
			this.notifyObservers();
		}
	}

	private final Environment parent;
	private final List<Environment> children;
	private final Map<Ident, Binding> bindings;
	private boolean visible;

	public Environment() {
		this(null);
	}

	private Environment(Environment environment) {
		this.parent = environment;

		this.bindings = new HashMap<Ident, Binding>();
		this.children = new ArrayList<Environment>();

		this.visible = true;
	}

	public Environment getChildEnvironment() {
		Environment child = new Environment(this);
		child.addObserver(this);
		this.children.add(child);
		return child;
	}

	public List<Environment> getChildren() {
		return this.children;
	}

	public void declare(Ident ident, Widget widget) {
		// A new variable gets the default value: Undefined.
		this.bindings.put(ident, new Binding(widget, Undefined.UNDEFINED));
		this.addObserver(ident, this);
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

	public Map<Ident, AbstractValue> getValues() {
		Map<Ident, AbstractValue> values = new HashMap<Ident, AbstractValue>();
		for (Map.Entry<Ident, Binding> entry : this.bindings.entrySet()) {
			Binding binding = entry.getValue();
			values.put(entry.getKey(), binding.getValue());
		}

		return values;
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

	public void setVisible(boolean isVisible) {
		this.visible = isVisible;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.isCompleted()) {
			// Persist results
			this.setChanged();
			this.notifyObservers();
		}
	}

	private boolean isCompleted() {
		if (this.parent != null) {
			return this.parent.isCompleted();
		} else {
			return this.isCompletedRecursive();
		}
	}

	private boolean isCompletedRecursive() {
		if (!this.visible) {
			return true;
		}

		for (Map.Entry<Ident, Binding> entry : this.bindings.entrySet()) {
			if (entry.getValue().getValue().equals(Undefined.UNDEFINED)) {
				return false;
			}
		}

		for (Environment child : this.children) {
			if (!child.isCompletedRecursive()) {
				return false;
			}
		}

		return true;
	}

}
