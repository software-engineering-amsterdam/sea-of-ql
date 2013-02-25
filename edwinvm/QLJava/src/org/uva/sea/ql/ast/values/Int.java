package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;

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
	public Value add(Value value)     { return value.addInt(this); }
	@Override
	public Value sub(Value value)     { return value.subInt(this); }
	@Override
	public Value div(Value value)     { return value.divInt(this); }
	@Override
	public Value mul(Value value)     { return value.mulInt(this); }
	@Override
	protected Value addInt(Int value) { return new Int(value.getValue() + getValue()); }
	@Override
	protected Value subInt(Int value) { return new Int(value.getValue() - getValue()); }
	@Override
	protected Value mulInt(Int value) { return new Int(value.getValue() * getValue()); }
	@Override
	protected Value divInt(Int value) { return new Int(value.getValue() / getValue()); }
	
	@Override
	public Value equalsValue(Value value) { return value.equalsInt(this); }
	@Override
	protected Value equalsInt(Int value)  { return new Bool(value.equals(this)); }
	@Override
	public Value greaterThan(Value value) { return value.greaterThanInt(this); }
	@Override
	protected Value greaterThanInt(Int value) { return new Bool(value.getValue() > getValue()); }
	@Override
	public Value greaterThanOrEqualTo(Value value) { return value.greaterThanOrEqualToInt(this); }
	@Override
	protected Value greaterThanOrEqualToInt(Int value) { return new Bool(value.getValue() >= getValue()); }
	@Override
	public Value lessThanOrEqualTo(Value value) { return value.lessThanOrEqualToInt(this); }
	@Override
	protected Value lessThanOrEqualToInt(Int value) { return new Bool(value.getValue() <= getValue()); }
	
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