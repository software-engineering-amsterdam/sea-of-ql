package org.uva.sea.ql.ast.values;

public class IntValue extends Value {
	
	private final Integer value;
	
	public IntValue(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != getClass())
			return false;
		if (obj == this)
			return true;
		
		return ((IntValue)obj).getValue().equals(getValue());
	}
}
