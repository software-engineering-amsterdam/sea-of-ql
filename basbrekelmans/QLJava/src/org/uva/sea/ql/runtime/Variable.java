package org.uva.sea.ql.runtime;

import java.util.Observable;
import java.util.Observer;

import org.uva.sea.ql.runtime.values.Value;

public class Variable extends Observable implements Observer {

	private Value value = Value.UNSET_VALUE;
	protected Observer valueSetter;

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

	public void setValueSetter(final Observer observer) {
		this.valueSetter = observer;
	}

	@Override
	public void update(final Observable o, final Object arg) {

	}
}
