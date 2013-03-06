package org.uva.sea.ql.evaluation.values;

public class Str extends Value {

	private final String value;

	public Str(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

}
