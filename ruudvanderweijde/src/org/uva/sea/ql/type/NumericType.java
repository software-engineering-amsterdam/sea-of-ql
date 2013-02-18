package org.uva.sea.ql.type;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumericType();
	}
	
	@Override
	public boolean isCompatibleToNumericType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToIntegerType() {
		return true;
	}
	
	@Override
	public String toString() {
		return "NumericType";
	}

	@Override
	public boolean validate(String value) {
		try{
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}}
