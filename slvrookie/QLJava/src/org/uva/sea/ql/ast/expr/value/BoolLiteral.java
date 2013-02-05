package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.interfaces.IExprVisitor;

public class BoolLiteral extends Value {

	private final boolean value;

	public BoolLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new BoolType();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

	@Override
	public Value and(Value value) {
		return value.andBool(this);
	}

	@Override
	public Value andBool(BoolLiteral value) {
		return new BoolLiteral(value.getValue() && getValue());
	}

	@Override
	public Value or(Value value) {
		return value.orBool(this);
	}

	@Override
	public Value orBool(BoolLiteral value) {
		return new BoolLiteral(value.getValue() || getValue());
	}

	@Override
	public Value eq(Value value) {
		return value.eqBool(this);
	}

	@Override
	public Value eqBool(BoolLiteral value) {
		return new BoolLiteral(value.getValue() == getValue());
	}

	@Override
	public Value neq(Value value) {
		return value.neqBool(this);
	}

	@Override
	public Value neqBool(BoolLiteral value) {
		return new BoolLiteral(value.getValue() != getValue());
	}

	@Override
	public Value not() {
		return new BoolLiteral(!getValue());
	}

}
