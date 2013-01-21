package org.uva.sea.ql.ast.types;

public class TypeInt extends ReturnType {

	private final Integer value;

	public TypeInt(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
}
