package org.uva.sea.ql.ast.types;

public class TypeMoney extends ReturnType {

	private final Integer value;

	public TypeMoney(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
}
