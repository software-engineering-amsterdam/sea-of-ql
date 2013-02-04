package org.uva.sea.ql.visitor.eval.value;

public class Money extends AbstractValue {

	private final float value;

	public Money(float value) {
		this.value = value;
	}

	public float getValue() {
		return this.value;
	}

}
