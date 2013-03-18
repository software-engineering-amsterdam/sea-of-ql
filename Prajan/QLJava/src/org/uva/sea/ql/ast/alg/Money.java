package org.uva.sea.ql.ast.alg;

import java.util.Map;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.MoneyType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.AlgebricElementVisitor;
import org.uva.sea.ql.visitor.Value;

public class Money extends Value {
	private final double value;

	public double getValue() {
		return value;
	}

	public Money(double value) {
		this.value = value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new MoneyType();
	}

	@Override
	public <T> T accept(AlgebricElementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value add(Value arg) {
		return arg.addMoney(this);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subMoney(this);
	}

	@Override
	public Value div(Value arg) {
		return arg.divMoney(this);
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulMoney(this);
	}

	@Override
	public Value addMoney(Money arg) {
		return new Money(arg.getValue() + getValue());
	}

	@Override
	public Value subMoney(Money arg) {
		return new Money(arg.getValue() - getValue());
	}

	@Override
	public Value mulMoney(Money arg) {
		return new Money(arg.getValue() * getValue());
	}

	@Override
	public Value divMoney(Money arg) {
		return new Money(arg.getValue() / getValue());
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}

}
