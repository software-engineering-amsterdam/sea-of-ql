package org.uva.sea.ql.ast.types;

public class TypeString extends ReturnType {
	
	private final Integer value;

	public TypeString(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
