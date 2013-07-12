package org.uva.sea.ql.ast.value;

import java.util.Observable;

public abstract class Value<T> extends Observable {
	public boolean isNumeric() { return false; }
	public boolean isString() { return false; }
	public boolean isBoolean() { return false; }
	public abstract T getValue();
	public abstract boolean setValue(T val);
	public abstract boolean setValue(String s);
	@Override
	public String toString() {
		return getValue().toString();
	}
}
