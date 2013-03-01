package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.TypeEnvironment;

public class Int extends Value {

	private final Integer _value;
	
	public Int(Integer value) {
		_value = value;
	}
	
	public Integer getValue() {
		return _value;
	}
	
	/*
	* NB: below the arguments are reversed because of double dispatch.
	*/
	
	@Override
	public Value add(Value value)            { return value.addInt(this); }
	@Override
	public Value divideBy(Value value)       { return value.divideByInt(this);   }
	@Override
	public Value multiplyBy(Value value)     { return value.multiplyByInt(this); }
	@Override
	public Value subtractBy(Value value)     { return value.subtractByInt(this); }
	@Override
	protected Value addInt(Int value)        { return new Int(value.getValue() + getValue()); }
	@Override
	protected Value subtractByInt(Int value) { return new Int(value.getValue() - getValue()); }
	@Override
	protected Value multiplyByInt(Int value) { return new Int(value.getValue() * getValue()); }
	@Override
	protected Value divideByInt(Int value)   { return new Int(value.getValue() / getValue()); }
	
	@Override
	public Value equalsValue(Value value)    { return value.equalsInt(this); }
	@Override
	protected Value equalsInt(Int value)     { return new Bool(value.equals(this)); }
	@Override
	public Value isGreaterThan(Value value)     { return value.isGreaterThanInt(this); }
	@Override
	protected Value isGreaterThanInt(Int value) { return new Bool(value.getValue() > getValue()); }
	@Override
	public Value isGreaterThanOrEqualTo(Value value) { return value.isGreaterThanOrEqualToInt(this); }
	@Override
	protected Value isGreaterThanOrEqualToInt(Int value) { return new Bool(value.getValue() >= getValue()); }
	@Override
	public Value isLessThan(Value value) { return value.isLessThanInt(this); }
	@Override
	protected Value isLessThanInt(Int value) { return new Bool(value.getValue() < getValue()); }
	@Override
	public Value isLessThanOrEqualTo(Value value) { return value.isLessThanOrEqualToInt(this); }
	@Override
	protected Value isLessThanOrEqualToInt(Int value) { return new Bool(value.getValue() <= getValue()); }
	@Override
	public Value notEqualsValue(Value value) { return value.notEqualsInt(this); }
	@Override
	protected Value notEqualsInt(Int value)  { return new Bool(!value.equals(this)); }
	
	@Override
	public Value setToPositive() { return new Int(Math.abs(getValue())); }
	@Override
	public Value setToNegative() { return new Int(-getValue()); }
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new org.uva.sea.ql.ast.types.Int();
	}	
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_value == null) ? 0 : _value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Int integer = (Int) obj;
		return this.getValue().equals(integer.getValue());
	}
}