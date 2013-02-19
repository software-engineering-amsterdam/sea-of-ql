package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefinedType;
import org.uva.sea.ql.ast.visitor.Visitor;

public class UndefinedValue extends Value {

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new UndefinedType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		throw new RuntimeException("Can not visit Type UndefinedValue");
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public boolean isDefined() {
		return false;
	}

	@Override
	public UndefinedValue getValue() {
		return this;
	}

	@Override
	public Value add(Value arg) {
		return this;
	}

	@Override
	public Value and(Value arg) {
		return this;
	}

	@Override
	public Value or(Value arg) {
		return new Bool(arg.isDefined() && (Boolean) arg.getValue());
	}

	@Override
	public Value equ(Value arg) {
		return this;
	}

	@Override
	public Value nEqu(Value arg) {
		return this;
	}

	@Override
	public Value not() {
		return this;
	}

	@Override
	protected Value notBool(Bool arg) {
		return new Bool((Boolean) arg.getValue());
	}

	@Override
	public Value pos() {
		return this;
	}

	@Override
	public Value div(Value arg) {
		return this;
	}

	@Override
	public Value mul(Value arg) {
		return this;
	}

	@Override
	public Value sub(Value arg) {
		return this;
	}

	@Override
	public Value neg() {
		return this;
	}

	@Override
	public Value lt(Value arg) {
		return this;
	}

	@Override
	public Value lEq(Value arg) {
		return this;
	}

	@Override
	public Value gt(Value arg) {
		return this;
	}

	@Override
	public Value gEq(Value arg) {
		return this;
	}

	@Override
	protected Value andBool(Bool arg) {
		return this;
	}

	@Override
	protected Value orBool(Bool arg) {
		return this;
	}

	@Override
	protected Value equBool(Bool arg) {
		return this;
	}

	@Override
	protected Value addInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value divInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value mulInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value subInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value equInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value posInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value negInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value ltInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value lEqInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value gtInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value gEqInt(Numeric arg) {
		return this;
	}

	@Override
	protected Value nEquInt(Numeric arg) {
		return this;
	}

}
