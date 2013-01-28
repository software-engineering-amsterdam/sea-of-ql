package org.uva.sea.ql.ast.types;

public abstract class Type {

	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToIntType() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToStringType() {
		return false;
	}

	public boolean isCompatibleToBoolType() {
		return false;
	}

	public boolean isCompatibleToMoneyType() {
		return false;
	}

}
