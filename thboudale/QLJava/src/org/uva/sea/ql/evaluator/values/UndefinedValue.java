package org.uva.sea.ql.evaluator.values;

public class UndefinedValue extends AValue {
	
	@Override
	public UndefinedValue getValue() {
		return this;
	}
	
	public AValue add(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue sub(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue mul(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue div(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue and(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue or(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue eq(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue neq(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue gt(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue geq(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue lt(AValue arg) {
		return new UndefinedValue();
	}
	
	public AValue leq(AValue arg) {
		return new UndefinedValue();
	}
	
	
	public AValue pos() {
		return new UndefinedValue();
	}
	
	public AValue neg() {
		return new UndefinedValue();
	}
	
	public AValue not() {
		return new UndefinedValue();
	}
}