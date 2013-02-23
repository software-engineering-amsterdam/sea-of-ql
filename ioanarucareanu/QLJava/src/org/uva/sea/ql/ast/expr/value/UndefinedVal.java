package org.uva.sea.ql.ast.expr.value;

public class UndefinedVal extends Val {
	
	@Override
	public Val add(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val substract(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val multiplyBy(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val divideBy(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val lessThan(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val greaterThan(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val equalTo(Val value) {

		return new UndefinedVal();
	}

	@Override
	public Val notEqualTo(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val lessOrEqualTo(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val greaterOrEqualTo(Val value) {
		
		return new UndefinedVal();
	}

	@Override
	public Val and(Val bool) {
		
		return new UndefinedVal();
	}

	@Override
	public Val or(Val bool) {
		
		return new UndefinedVal();
	}

	@Override
	public Val not() {
		
		return new UndefinedVal();
	}

	@Override
	public String toString() {
		return "";
	}
	
}
