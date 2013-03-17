package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.alg.Bool;
import org.uva.sea.ql.ast.alg.Int;
import org.uva.sea.ql.ast.alg.Money;

public abstract class Value extends Expr {
	public abstract String toString();

	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value equals(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value addMoney(Money arg) {
		throw new UnsupportedOperationException();
	}

	public Value divMoney(Money arg) {
		throw new UnsupportedOperationException();
	}

	public Value mulMoney(Money arg) {
		throw new UnsupportedOperationException();
	}

	public Value subMoney(Money arg) {
		throw new UnsupportedOperationException();
	}

	public Value equalsBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value equalsInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public boolean isDefined() {
		return true;
	}
}
