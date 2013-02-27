package org.uva.sea.ql.ast.expr.value;

public class IntegerVal extends Val {
	
	private int value;
	
	public IntegerVal() {
		value = 0;
	}
	
	public IntegerVal(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Val add(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new IntegerVal(getValue() + ((IntegerVal)value).getValue());
	}

	public Val substract(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new IntegerVal(getValue() - ((IntegerVal)value).getValue());
	}

	public Val multiplyBy(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new IntegerVal(getValue() * ((IntegerVal)value).getValue());
	}

	public Val divideBy(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new IntegerVal(getValue() / ((IntegerVal)value).getValue());
	}
	
	public Val lessThan(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal(getValue() < ((IntegerVal)value).getValue());
	}
	
	public Val greaterThan(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal(getValue() > ((IntegerVal)value).getValue());
	}
	
	public Val equalTo(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal(getValue() == ((IntegerVal)value).getValue());
	}
	
	public Val notEqualTo(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return equalTo(value).not();
	}
	
	public Val lessOrEqualTo(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal((BooleanVal)lessThan(value).or(equalTo(value)));
	}
	
	public Val greaterOrEqualTo(Val value) {
		if (value.getClass().equals(UndefinedVal.class)) {
			return new UndefinedVal();
		}
		return new BooleanVal((BooleanVal)greaterThan(value).or(equalTo(value)));
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}


}
