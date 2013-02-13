package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitors.interfaces.IExprVisitor;

public class IntLiteral extends Value {

	private final int value;

	public IntLiteral(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new IntType();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

	@Override
	public Value add(Value value) {
		return value.addInt(this);
	}

	@Override
	public Value addInt(IntLiteral value) {
		return new IntLiteral(value.getValue() + getValue());
	}

	@Override
	public Value sub(Value value) {
		return value.subInt(this);
	}

	@Override
	public Value subInt(IntLiteral value) {
		return new IntLiteral(value.getValue() - getValue());
	}

	@Override
	public Value div(Value value) {
		return value.divInt(this);
	}

	@Override
	public Value divInt(IntLiteral value) {
		return new IntLiteral(value.getValue() / getValue());
	}

	@Override
	public Value mul(Value value) {
		return value.mulInt(this);
	}

	@Override
	public Value mulInt(IntLiteral value) {
		return new IntLiteral(value.getValue() * getValue());
	}

	@Override
	public Value geq(Value value) {
		return value.geqInt(this);
	}

	@Override
	public Value geqInt(IntLiteral value) {
		return new BoolLiteral(value.getValue() >= getValue());
	}

	@Override
	public Value gt(Value value) {
		return value.gtInt(this);
	}

	@Override
	public Value gtInt(IntLiteral value) {
		return new BoolLiteral(value.getValue() > getValue());
	}

	@Override
	public Value leq(Value value) {
		return value.leqInt(this);
	}

	@Override
	public Value leqInt(IntLiteral value) {
		return new BoolLiteral(value.getValue() <= getValue());
	}

	@Override
	public Value lt(Value value) {
		return value.ltInt(this);
	}

	@Override
	public Value ltInt(IntLiteral value) {
		return new BoolLiteral(value.getValue() < getValue());
	}

	@Override
	public Value eq(Value value) {
		return value.eqInt(this);
	}

	@Override
	public Value eqInt(IntLiteral value) {
		return new BoolLiteral(value.getValue() == getValue());
	}

	@Override
	public Value neq(Value value) {
		return value.neqInt(this);
	}

	@Override
	public Value neqInt(IntLiteral value) {
		return new BoolLiteral(value.getValue() != getValue());
	}

	@Override
	public Value neg() {
		return new IntLiteral(-this.value);
	}

	@Override
	public Value pos() {
		return new IntLiteral(+this.value);
	}
	
	@Override
	public boolean isOfValue(Value v) {
		return v.isIntLiteral();
	}
	
	@Override
	public boolean isIntLiteral() {
		return true;
	}
}
