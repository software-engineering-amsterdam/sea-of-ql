package org.uva.sea.ql.interpreter.controller;

import java.io.Serializable;

import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.type.Type;

public class TypeValuePair implements Serializable {
	private Type type;
	private Val value;
	
	public TypeValuePair(Type type, Val value) {
		super();
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Val getValue() {
		return value;
	}

	public void setValue(Val value) {
		this.value = value;
	}
	

}
