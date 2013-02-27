package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.TypeBool;
import org.uva.sea.ql.ast.visitor.VisitorExpressions;

public class BoolValue extends Value {
	
	private final boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
	
	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new TypeBool();
	}

	@Override
	public <T> T accept(VisitorExpressions<T> visitor) {
		return  visitor.visit(this);
	}

	@Override
	public Value and(Value value) {
		return value.andBool(this);
	}
	
	@Override
	public Value andBool(BoolValue value) {
		return new BoolValue(value.getValue() && getValue());
	}

	@Override
	public Value or(Value value) {
		return value.orBool(this);
	}

	@Override
	public Value orBool(BoolValue value) {
		return new BoolValue(value.getValue() || getValue());
	}

	@Override
	public Value not() {
		return new BoolValue(!(getValue()));
	}
}
