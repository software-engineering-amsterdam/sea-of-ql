package org.uva.sea.ql.ast.expr.value;

public class BooleanVal extends Val {
	
	private boolean value;
	
	public BooleanVal() {
		value = false;
	}
	
	public BooleanVal(boolean value) {
		this.value = value;
	}

	public BooleanVal(BooleanVal val) {
		this.value = val.getValue();
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public Val and(Val bool) {
		if (bool.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal(getValue() && ((BooleanVal)bool).getValue());
	}

	public Val or(Val bool) {
		if (bool.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal(getValue() || ((BooleanVal)bool).getValue());
	}

	public BooleanVal not() {
		return new BooleanVal(!getValue());
	}
	
	public Val equalTo(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal(getValue() == ((BooleanVal)value).getValue());
	}
	
	public Val notEqualTo(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return equalTo(value).not();
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
