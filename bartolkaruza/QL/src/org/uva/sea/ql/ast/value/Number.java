package org.uva.sea.ql.ast.value;

public class Number extends Value {

	private java.lang.Integer value;

	public Number() {
		this.setValue(0);
	}

	public Number(java.lang.Integer initialValue) {
		this.setValue(initialValue);
	}

	public java.lang.Integer getValue() {
		return value;
	}

	public void setValue(java.lang.Integer value) {
		this.value = value;
	}

}
