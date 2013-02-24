package org.uva.sea.ql.ast.values;

public class Int extends Value {
	private final Integer _value;
	
	public Int(Integer value) {
		_value = value;
	}
	
	public Integer getValue() {
		return _value;
	}
}