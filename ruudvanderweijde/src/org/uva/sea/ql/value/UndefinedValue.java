package org.uva.sea.ql.value;

public class UndefinedValue extends BooleanValue {

	public UndefinedValue() {
		// By the rules of QL:
		// a value of an UndefinedType is always false
		super(false);
	}
}
