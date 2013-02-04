package org.uva.sea.ql.visitor.eval.value;

public class Int extends AbstractValue {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return this.value;
	}

}
