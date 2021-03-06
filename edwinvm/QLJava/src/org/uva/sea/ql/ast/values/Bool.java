package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.check.TypeEnvironment;

public class Bool extends Value {

	private final Boolean _value;
	
	public Bool(Boolean value) {
		_value = value;
	}
	
	@Override
	public Boolean getValue() {
		return _value;
	}
	
	@Override
	public Value applyNegation() { return new Bool(!getValue()); }
	@Override
	public Value isEquivalentTo(Value value) { return new Bool(((Bool)value).getValue() && getValue()); }
	@Override
	public Value isEquivalentOrNotEquivalentTo(Value value)  { return new Bool(((Bool)value).getValue() || getValue()); }
	@Override
	public Value equalsValue(Value value) { return value.equalsBool(this); }
	@Override
	protected Value equalsBool(Bool value)  { return new Bool(value.equals(this)); }
	@Override
	public Value notEqualsValue(Value value) { return value.notEqualsBool(this); }
	@Override
	protected Value notEqualsBool(Bool value)  { return new Bool(!value.equals(this)); }
	
	@Override
	public Type typeOf(TypeEnvironment typeEnvironment) {
		return new org.uva.sea.ql.ast.types.Bool();
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
		Bool bool = (Bool) obj;
		return this.getValue().equals(bool.getValue());
	}
}