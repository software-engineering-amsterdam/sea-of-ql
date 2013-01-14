package org.uva.sea.ql.ast.value;

public class TextString extends Value {

	private java.lang.String value;

	public TextString() {
		this.setValue("");
	}

	public TextString(java.lang.String initialValue) {
		this.setValue(initialValue);
	}

	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

}
