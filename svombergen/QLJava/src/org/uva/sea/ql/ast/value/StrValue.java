package org.uva.sea.ql.ast.value;

public class StrValue extends Value<String> {
	
	String value;
	
	public StrValue(String s) {
		value = s;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public boolean isString() {
		return true;
	}

	@Override
	public boolean setValue(String val) {
		if (val == null)
			return false;
		
		value = val;
		
		setChanged();
		notifyObservers();
		
		return true;
	}

}
