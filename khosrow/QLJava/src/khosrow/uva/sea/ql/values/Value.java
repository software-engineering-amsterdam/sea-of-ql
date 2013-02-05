package khosrow.uva.sea.ql.values;

public abstract class Value {
	
	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value mod(Value arg) {
		throw new UnsupportedOperationException();
	}	
	
	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value pos() {
		throw new UnsupportedOperationException();
	}
	
	public Value neg() {
		throw new UnsupportedOperationException();
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}
	
	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @param value
	 * @return
	 * zero if this object represents the same value as the argument; 
	 * a positive value if this object represents a value greater than the argument; 
	 * and a negative value if this object represents a value less than the argument.

	 */
	public abstract int compareTo(Value value);	// TODO: change this to protected!
	
	protected Value addInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value modInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addMoney(MoneyVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subMoney(MoneyVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulMoney(MoneyVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divMoney(MoneyVal arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value modMoney(MoneyVal arg) {
		throw new UnsupportedOperationException();
	}
	
}
