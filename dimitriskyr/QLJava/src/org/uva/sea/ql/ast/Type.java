package org.uva.sea.ql.ast;

public abstract class Type {
	public abstract boolean isCompatibleTo(Type t);

	public boolean isCompatibleToBoolean() {
		return false;
	}

	public boolean isCompatibleToString() {
		return false;
	}

	public boolean isCompatibleToNumeric() {
		return false;
	}

	public boolean isCompatibleToInteger() {
		return false;
	}

	public boolean isCompatibleToMoney() {
		return false;
	}

	public boolean isCompatibleToError() {
		return false;
	}

}
