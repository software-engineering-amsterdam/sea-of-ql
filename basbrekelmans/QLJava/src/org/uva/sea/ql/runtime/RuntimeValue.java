package org.uva.sea.ql.runtime;

import java.util.Observable;

import org.uva.sea.ql.runtime.values.Value;

public abstract class RuntimeValue extends Observable {

	private Value value = Value.UNSET_VALUE;

	public Value getValue() {
		return this.value;
	}

	public boolean hasValue() {
		return this.value != Value.UNSET_VALUE;
	}

	public boolean isComputed() {
		return false;
	}

	public void setValue(final Value value) {
		this.value = value;
		this.setChanged();
		this.notifyObservers();
	}
}
