package org.uva.sea.ql.ast;

public class BooleanType extends TypeDescription {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public boolean compatibleType(TypeDescription testType) {
		if (testType.getClass() == BooleanType.class) {
			return true;
		}
		return false;
	}
}
