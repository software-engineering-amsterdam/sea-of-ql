package org.uva.sea.ql.value;

abstract public class NumberValue extends Value {
	private final Number value;

	public NumberValue( Number value ) {
		this.value = value;
	}

	@Override
	public Number getValue() {
		return this.value;
	}
}