package org.uva.sea.ql.ast.values;

public class Str extends Value {
	private final String _value;
	
	public Str(String value) {
		_value = value;
	}
	
	public String getValue() {
		return _value;
	}
}