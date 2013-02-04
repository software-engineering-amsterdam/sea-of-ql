package org.uva.sea.ql.visitor.eval.value;

public class Bool extends AbstractValue {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

}
