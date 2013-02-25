package org.uva.sea.ql.ast.values;

public class Bool extends Value {
	private final boolean _value;
	
	public Bool(boolean value) {
		_value = value;
	}
	
	public boolean getValue() {
		return _value;
	}
}