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
		return "Undefined!";
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
		return arg;
	}

	@Override
	public Value and(Value arg) {
		return new Bool(false);
	}

	@Override
	public Value or(Value arg) {
		return arg;
	}

	@Override
	public Value equ(Value arg) {
		return new Bool(false);
	}

	@Override
	public Value nEqu(Value arg) {
		return new Bool(false);
	}

	@Override
	public Value not() {
		return this;
	}

	@Override
	protected Value notBool(Bool arg) {
		return arg;
	}

	@Override
	public Value pos() {
		return this;
	}

	@Override
	public Value div(Value arg) {
		return arg;
	}

	@Override
	public Value mul(Value arg) {
		return arg;
	}

	@Override
	public Value sub(Value arg) {
		return arg;
	}

	@Override
	public Value neg() {
		return this;
	}

	@Override
	public Value lt(Value arg) {
		return new Bool(false);
	}

	@Override
	public Value lEq(Value arg) {
		return new Bool(false);
	}

	@Override
	public Value gt(Value arg) {
		return new Bool(false);
	}

	@Override
	public Value gEq(Value arg) {
		return new Bool(false);
	}

	@Override
	protected Value andBool(Bool arg) {
		return new Bool(false);
	}

	@Override
	protected Value orBool(Bool arg) {
		return new Bool(false);
	}

	@Override
	protected Value equBool(Bool arg) {
		return new Bool(false);
	}

	@Override
	protected Value addInt(Numeric arg) {

		return arg;
	}

	@Override
	protected Value divInt(Numeric arg) {

		return arg;
	}

	@Override
	protected Value mulInt(Numeric arg) {

		return arg;
	}

	@Override
	protected Value subInt(Numeric arg) {
		return arg;
	}

	@Override
	protected Value equInt(Numeric arg) {
		return new Bool(false);
	}

	@Override
	protected Value posInt(Numeric arg) {

		return new Int(arg.getValue().intValue());
	}

	@Override
	protected Value negInt(Numeric arg) {

		return new Int(-arg.getValue().intValue());
	}

	@Override
	protected Value ltInt(Numeric arg) {

		return new Bool(false);
	}

	@Override
	protected Value lEqInt(Numeric arg) {

		return new Bool(false);
	}

	@Override
	protected Value gtInt(Numeric arg) {

		return new Bool(false);
	}

	@Override
	protected Value gEqInt(Numeric arg) {
		return new Bool(false);
	}

	@Override
	protected Value nEquInt(Numeric arg) {
		return new Bool(false);
	}

}
