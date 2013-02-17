package org.uva.sea.ql.visitor.eval.value;

public class String extends AbstractValue {

	private final java.lang.String value;

	public String(java.lang.String value) {
		this.value = value;
	}

	public java.lang.String getValue() {
		return this.value;
	}

}
