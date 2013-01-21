package org.uva.sea.ql.ast;

public class StringType extends TypeDescription {

	public StringType() {
		super("string");
	}

	@Override
	public boolean compatibleType(TypeDescription testType) {
		if (testType.getClass() == StringType.class) {
			return true;
		}
		return false;
	}
}
