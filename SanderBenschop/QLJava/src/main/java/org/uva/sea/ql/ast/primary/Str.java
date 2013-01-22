package org.uva.sea.ql.ast.primary;

public final class Str extends Datatype<String> {

	private final String value;
	
	public Str(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}
}
