package org.uva.sea.ql.ast.value;

public class Bool extends Value {

	private java.lang.Boolean value;

	public Bool() {
		value = false;
	}

	public Bool(java.lang.Boolean initialValue) {
		this.value = initialValue;
	}

	public java.lang.Boolean getValue() {
		return value;
	}

	public void setValue(java.lang.Boolean value) {
		this.value = value;
	}

}
