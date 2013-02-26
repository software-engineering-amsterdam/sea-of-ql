package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.visitor.ICheckExprVisitor;

public class Money extends Value {
	private final float value;

	public Money(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public <T> T accept(ICheckExprVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Type typeOf(Map<String, Type> typeEnv) {
		return new MoneyType();
	}

	@Override
	public Value add(Value arg) {
		return arg.addMoney(this);
	}

	@Override
	public Value addMoney(Money arg) {
		return new Money(arg.getValue() + getValue());
	}

	@Override
	public Value div(Value arg) {
		return arg.divMoney(this);
	}

	@Override
	public Value divMoney(Money arg) {
		return new Money(arg.getValue() / getValue());
	}

	@Override
	public Value eq(Value arg) {
		return arg.eqMoney(this);
	}

	@Override
	public Value eqMoney(Money arg) {
		return new Bool(arg.getValue() == getValue());
	}

	@Override
	public Value geq(Value arg) {
		return arg.geqMoney(this);
	}

	@Override
	public Value geqMoney(Money arg) {
		return new Bool(arg.getValue() >= getValue());
	}

	@Override
	public Value gt(Value arg) {
		return arg.gtMoney(this);
	}

	@Override
	public Value gtMoney(Money arg) {
		return new Bool(arg.getValue() > getValue());
	}

	@Override
	public Value leq(Value arg) {
		return arg.leqMoney(this);
	}

	@Override
	public Value leqMoney(Money arg) {
		return new Bool(arg.getValue() <= getValue());
	}

	@Override
	public Value lt(Value arg) {
		return arg.ltMoney(this);
	}

	@Override
	public Value ltMoney(Money arg) {
		return new Bool(arg.getValue() < getValue());
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulMoney(this);
	}

	@Override
	public Value mulMoney(Money arg) {
		return new Money(arg.getValue() * getValue());
	}

	@Override
	public Value neg() {
		return new Money(-this.value);
	}

	@Override
	public Value neq(Value arg) {
		return arg.neqMoney(this);
	}

	@Override
	public Value neqMoney(Money arg) {
		return new Bool(arg.getValue() != getValue());
	}

	@Override
	public Value pos() {
		return new Money(+this.value);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subMoney(this);
	}

	@Override
	public Value subMoney(Money arg) {
		return new Money(arg.getValue() - getValue());
	}

}
