package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.TypeEnvironment;

public class Money extends Value {

	private final Double _value;
	
	public Money(Double value) {
		_value = value;
	}
	
	@Override
	public Double getValue() {
		return _value;
	}

	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new org.uva.sea.ql.ast.types.Money();
	}	
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	/*
	* NB: below the arguments are reversed because of double dispatch.
	*/
	
	@Override
	public Value add(Value value)                { return value.addMoney(this); }
	@Override
	public Value divideBy(Value value)           { return value.divideByMoney(this);   }
	@Override
	public Value multiplyBy(Value value)         { return value.multiplyByMoney(this); }
	@Override
	public Value subtractBy(Value value)         { return value.subtractByMoney(this); }
	@Override
	protected Value addMoney(Money value)        { return new Money(value.getValue() + getValue()); }
	@Override
	protected Value subtractByMoney(Money value) { return new Money(value.getValue() - getValue()); }
	@Override
	protected Value multiplyByMoney(Money value) { return new Money(value.getValue() * getValue()); }
	@Override
	protected Value divideByMoney(Money value)   { return new Money(value.getValue() / getValue()); }
	
	@Override
	public Value equalsValue(Value value) { return value.equalsMoney(this); }
	@Override
	protected Value equalsMoney(Money value) { return new Bool(value.equals(this)); }
	@Override
	public Value isGreaterThan(Value value) { return value.isGreaterThanMoney(this); }
	@Override
	protected Value isGreaterThanMoney(Money value)  { return new Bool(value.getValue() > getValue()); }
	@Override
	public Value isGreaterThanOrEqualTo(Value value) { return value.isGreaterThanOrEqualToMoney(this); }
	@Override
	protected Value isGreaterThanOrEqualToMoney(Money value) { return new Bool(value.getValue() >= getValue()); }
	@Override
	public Value isLessThan(Value value) { return value.isLessThanMoney(this); }
	@Override
	protected Value isLessThanMoney(Money value) { return new Bool(value.getValue() < getValue()); }
	@Override
	public Value isLessThanOrEqualTo(Value value) { return value.isLessThanOrEqualToMoney(this); }
	@Override
	protected Value isLessThanOrEqualToMoney(Money value) { return new Bool(value.getValue() <= getValue()); }
	@Override
	public Value notEqualsValue(Value value) { return value.notEqualsMoney(this); }
	@Override
	protected Value notEqualsMoney(Money value) { return new Bool(!value.equals(this)); }
	
	@Override
	public Value setToPositive() { return new Money(Math.abs(getValue())); }
	@Override
	public Value setToNegative() { return new Money(-getValue()); }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_value == null) ? 0 : _value.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.getValue().equals(money.getValue());
	}
}