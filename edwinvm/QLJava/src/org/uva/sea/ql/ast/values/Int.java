package org.uva.sea.ql.ast.values;

public class Int extends Value {
	
	private final Integer _value;
	
	public Int(Integer value) {
		_value = value;
	}
	
	public Integer getValue() {
		return _value;
	}
	
	@Override
	public Value add(Value value) { return value.addInt(this); }
	@Override
	public Value sub(Value value) { return value.subInt(this); }
	@Override
	public Value div(Value value) { return value.divInt(this); }
	@Override
	public Value mul(Value value) { return value.mulInt(this); }
	
	// NB: below the arguments are reversed because of double dispatch.

	@Override
	protected Value addInt(Int value) { return new Int(value.getValue() + getValue()); }
	@Override
	protected Value subInt(Int value) { return new Int(value.getValue() - getValue()); }
	@Override
	protected Value mulInt(Int value) { return new Int(value.getValue() * getValue()); }
	@Override
	protected Value divInt(Int value) { return new Int(value.getValue() / getValue()); }

}