package org.uva.sea.ql.eval;

public class MoneyValue extends Value {

	private final Float value;
	
	public MoneyValue(Float value) {
		this.value = value;
	}

	public Float getValue() {
		return value;
	}
	
	public Value add(Value arg) {
		return arg.addMoney(this);
	}
	
	public Value div(Value arg) {
		return arg.divMoney(this);
	}
	
	public Value mul(Value arg) {
		return arg.mulMoney(this);
	}
	
	public Value pos() {
		return new MoneyValue(getValue());
	}
	
	public Value neg() {
		return new MoneyValue(-getValue());
	}
	
	public Value sub(Value arg) {
		return arg.subMoney(this);
	}
	
	public Value eq(Value arg) {
		return arg.eqMoney(this);
	}
	
	public Value geq(Value arg) {
		return arg.geqMoney(this);
	}
	
	public Value gt(Value arg) {
		return arg.gtMoney(this);
	}
	
	public Value leq(Value arg) {
		return arg.leqMoney(this);
	}
	
	public Value lt(Value arg) {
		return arg.ltMoney(this);
	}
	
	public Value neq(Value arg) {
		return arg.neqMoney(this);
	}
	
	protected Value addMoney(MoneyValue arg) {
		return new MoneyValue(arg.getValue() + getValue());
	}
	
	protected Value divMoney(MoneyValue arg) {
		return new MoneyValue(arg.getValue() / getValue());
	}
	
	protected Value mulMoney(MoneyValue arg) {
		return new MoneyValue(arg.getValue() * getValue());
	}
	
	protected Value subMoney(MoneyValue arg) {
		return new MoneyValue(arg.getValue() - getValue());
	}
	
	protected Value eqMoney(MoneyValue arg) {
		return new BooleanValue(arg.getValue() == getValue());
	}
	
	protected Value geqMoney(MoneyValue arg) {
		return new BooleanValue(arg.getValue() >= getValue());
	}
	
	protected Value gtMoney(MoneyValue arg) {
		return new BooleanValue(arg.getValue() > getValue());
	}
	
	protected Value leqMoney(MoneyValue arg) {
		return new BooleanValue(arg.getValue() <= getValue());
	}
	
	protected Value ltMoney(MoneyValue arg) {
		return new BooleanValue(arg.getValue() < getValue());
	}
	
	protected Value neqMoney(MoneyValue arg) {
		return new BooleanValue(arg.getValue() != getValue());
	}
	
	public boolean equals(Object other) {
		if (other instanceof MoneyValue) {
			Float x = getValue();
			Float y = ((MoneyValue)other).getValue();
			return x.equals(y);
		}
		return false;
	}
	
	public String toString() {
		return getValue().toString();
	}
	
}