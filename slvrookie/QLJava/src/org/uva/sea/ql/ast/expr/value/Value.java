package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Value extends Expr {

	abstract public Object getValue();

	public Value add(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value addInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value addMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value subInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value subMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value divInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value divMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value mulInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value mulMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value andBool(BoolLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value orBool(BoolLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value geq(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value geqInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value geqMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value gtInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value gtMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value leq(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value leqInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value leqMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value ltInt(IntLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value ltMoney(MoneyLiteral value) {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value value) {
		return new BoolLiteral(value.getValue().equals(this.getValue()));
	}

	public Value neq(Value value) {
		return new BoolLiteral(!value.getValue().equals(this.getValue()));
	}
}
