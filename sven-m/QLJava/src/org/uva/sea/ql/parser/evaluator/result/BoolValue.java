package org.uva.sea.ql.parser.evaluator.result;

public class BoolValue extends Value {
	private final boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(ValueVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	/*
	 * Relational operators
	 */

	@Override
	public Value eq(Value val) {
		return val.eqBool(this);
	}
	
	@Override
	public Value eqBool(BoolValue val) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Value neq(Value val) {
		return val.neqBool(this);
	}
	
	@Override
	public Value neqBool(BoolValue val) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Boolean operators
	 */
	@Override
	public Value not() {
		return new BoolValue(!getValue());
	}
	
	@Override
	public Value and(Value val) {
		return val.andBool(this);
	}
	
	@Override
	public Value andBool(BoolValue val) {
		return new BoolValue(val.getValue() && this.getValue());
	}
	
	@Override
	public Value or(Value val) {
		return val.orBool(this);
	}
	
	@Override
	public Value orBool(BoolValue val) {
		return new BoolValue(val.getValue() || this.getValue()); 
	}
}
