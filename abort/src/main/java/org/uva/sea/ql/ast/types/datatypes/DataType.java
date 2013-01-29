package org.uva.sea.ql.ast.types.datatypes;


public abstract class DataType {
	public boolean isCompatibleToInt() { return false; }
	public boolean isCompatibleToNumeric() { return false; }
	public boolean isCompatibleToString() { return false; }
	public boolean isCompatibleToBool() { return false; }
	public boolean isCompatibleToMoney() { return false; }
	public boolean isSameTypeAs(final DataType dataType) {
		if (dataType == null) return false;
		
		return (getClass().equals(dataType.getClass()));
	}
}
