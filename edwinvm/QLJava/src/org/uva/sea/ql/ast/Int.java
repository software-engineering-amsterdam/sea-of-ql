package org.uva.sea.ql.ast;

public class Int extends Expr {
	private final int _value;

	public Int(int value) {
		_value = value;
	}

	public int getValue() {
		return _value;
	}	
}