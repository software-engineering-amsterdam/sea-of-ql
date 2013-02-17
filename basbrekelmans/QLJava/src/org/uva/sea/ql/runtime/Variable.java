package org.uva.sea.ql.runtime;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.expressions.Identifier;

public class Variable implements IPropertyChangeListener<Variable>, IObservable<IPropertyChangeListener<Variable>> {
	
	private final Identifier identifier;
	private List<Variable> dependencies = new ArrayList<Variable>();
	private List<Variable> dependsOn = new ArrayList<Variable>();
	private final ArrayList<IPropertyChangeListener<Variable>> listeners = new ArrayList<IPropertyChangeListener<Variable>>();
	private Value value;
	
	public Variable(Identifier identifier) {
		this.identifier = identifier;
	}
	
	public Variable() {
		this.identifier = null;
	}
	
	public void addDependency(Variable value) {
		value.dependsOn.add(this);
		value.listeners.add(this);
		this.dependencies.add(value);
	}
	
	/**
	 * @return Variables that this value depends on.
	 */
	public Iterable<Variable> getDependsOn() {
		return dependsOn;
	}
	
	/**
	 * @return Variables that depend on this value.
	 */
	public Iterable<Variable> getDependencies() {
		return dependencies;
	}
	
	public void addValueChangedListener(IPropertyChangeListener<Variable> observer) {
		listeners.add(observer);
	}
	public void removeValueChangedListener(IPropertyChangeListener<Variable> observer) {
		if (listeners.contains(observer)) {
			listeners.remove(observer);
		}
	}

	public boolean hasIdentifier() {
		return identifier != null;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
		onValueChanged(this);
	}

	/*
	 * Occurs when a dependant value changes.
	 */
	@Override
	public void onValueChanged(Variable value) {
		for(IPropertyChangeListener<Variable> listener : listeners) {
			listener.onValueChanged(this);
		}
	}	
	
	@Override
	public String toString() {
		String ident = this.identifier == null ? "unnamed" : this.identifier.getName();
		return "var: '" + ident + "'";
	}
}
