package org.uva.sea.ql.ast.nodetypes.primary;

public final class Str extends Primary<String> {

	private final String value;
	
	public Str(String value) {
		this.value = value;
	}
	
	@Override
	public String getValue() {
		return value;
	}
}
