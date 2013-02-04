package org.uva.sea.ql.ast.expr.value;

import java.util.Map;

import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IExprVisitor;

public class MoneyLiteral extends Value {

	private final double value;

	public MoneyLiteral(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	

	@Override
	public Type typeOf(Map<String, Type> typeEnv) {
		return new MoneyType();
	}

	@Override
	public <T> T accept(IExprVisitor<T> ExprVisitor) {
		return ExprVisitor.visit(this);
	}

	@Override
	public Value add(Value value) {
		return value.addMoney(this);
	}

	@Override
	public Value addMoney(MoneyLiteral value) {
		return new MoneyLiteral(value.getValue() + getValue());
	}

	@Override
	public Value sub(Value value) {
		return value.subMoney(this);
	}

	@Override
	public Value subMoney(MoneyLiteral value) {
		return new MoneyLiteral(value.getValue() - getValue());
	}

	@Override
	public Value div(Value value) {
		return value.divMoney(this);
	}

	@Override
	public Value divMoney(MoneyLiteral value) {
		return new MoneyLiteral(value.getValue() / getValue());
	}

	@Override
	public Value mul(Value value) {
		return value.mulMoney(this);
	}

	@Override
	public Value mulMoney(MoneyLiteral value) {
		return new MoneyLiteral(value.getValue() * getValue());
	}

	@Override
	public Value geq(Value value) {
		return value.geqMoney(this);
	}

	@Override
	public Value geqMoney(MoneyLiteral value) {
		return new BoolLiteral(value.getValue() >= getValue());
	}

	@Override
	public Value gt(Value value) {
		return value.gtMoney(this);
	}

	@Override
	public Value gtMoney(MoneyLiteral value) {
		return new BoolLiteral(value.getValue() > getValue());
	}

	@Override
	public Value leq(Value value) {
		return value.leqMoney(this);
	}

	@Override
	public Value leqMoney(MoneyLiteral value) {
		return new BoolLiteral(value.getValue() <= getValue());
	}

	@Override
	public Value lt(Value value) {
		return value.ltMoney(this);
	}

	@Override
	public Value ltMoney(MoneyLiteral value) {
		return new BoolLiteral(value.getValue() < getValue());
	}

	@Override
	public Value eq(Value value) {
		return value.eqMoney(this);
	}

	@Override
	public Value eqMoney(MoneyLiteral value) {
		return new BoolLiteral(value.getValue() == getValue());
	}

	@Override
	public Value neq(Value value) {
		return value.neqMoney(this);
	}

	@Override
	public Value neqMoney(MoneyLiteral value) {
		return new BoolLiteral(value.getValue() != getValue());
	}

	@Override
	public Value neg() {
		return new MoneyLiteral(-this.value);
	}

	@Override
	public Value pos() {
		return new MoneyLiteral(+this.value);
	}

}
