package org.uva.sea.ql.ast.nodes.values;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Value extends Expr {
	protected Value value;

	public boolean isDefined() { //TODO, does this make sense ?!
		return this.value != null;
	}

	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}

	// BOOLEAN
	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value equ(Value arg) {
		// BOOL AND INT
		throw new UnsupportedOperationException();
	}

	public Value nEqu(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	// BOOLEAN INTERNAL

	protected Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	protected Value orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	protected Value equBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	protected Value notBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	// INTEGER

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

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value lEq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value gEq(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value pos(Value arg) {
		throw new UnsupportedOperationException();
	}

	// INTEGER INTERNAL
	protected Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value equInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value posInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value negInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value ltInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value lEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value gtInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value gEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	protected Value nEquInt(Int arg) {
		throw new UnsupportedOperationException();
	}

}
