package org.uva.sea.ql.ast.types;

public class TypeBool extends ReturnType {

	private final Integer value;

	public TypeBool(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}