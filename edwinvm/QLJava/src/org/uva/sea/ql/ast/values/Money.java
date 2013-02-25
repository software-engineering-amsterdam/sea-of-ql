package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

public class Money extends Value {

	private final Double _value;
	
	public Money(Double value) {
		_value = value;
	}
	
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
	public Value add(Value value)         { return value.addMoney(this); }
	@Override
	public Value sub(Value value)         { return value.subMoney(this); }
	@Override
	public Value div(Value value)         { return value.divMoney(this); }
	@Override
	public Value mul(Value value)         { return value.mulMoney(this); }
	@Override
	protected Value addMoney(Money value) { return new Money(value.getValue() + getValue()); }
	@Override
	protected Value subMoney(Money value) { return new Money(value.getValue() - getValue()); }
	@Override
	protected Value mulMoney(Money value) { return new Money(value.getValue() * getValue()); }
	@Override
	protected Value divMoney(Money value) { return new Money(value.getValue() / getValue()); }
	
	@Override
	public Value equalsValue(Value value) { return value.equalsMoney(this); }
	@Override
	protected Value equalsMoney(Money value) { return new Bool(value.equals(this)); }
	@Override
	public Value greaterThanOrEqualTo(Value value) { return value.greaterThanOrEqualToMoney(this); }
	@Override
	protected Value greaterThanOrEqualToMoney(Money value) { return new Bool(value.getValue() >= getValue()); }
	
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