package org.uva.sea.ql.ast.nodes.values;

import java.security.InvalidParameterException;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Str extends Value {

	private final String value;

	public Str(String val) {
		this.value = val.replaceAll("^\"|\"$", "");;
	}

	@Override
	public String toString() {
		return this.value+"";
	}

	@Override
	public boolean isDefined() {
		return value != null;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new StringType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value add(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value and(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value or(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value equ(Value arg) {
		return new Bool(arg.getValue().equals(this.value));
	}

	@Override
	public Value nEqu(Value arg) {
		return new Bool(!arg.getValue().equals(this.value));
	}

	@Override
	public Value not() {

		throw new InvalidParameterException();
	}

	@Override
	protected Value notBool(Bool arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value pos() {

		throw new InvalidParameterException();
	}

	@Override
	public Value div(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value mul(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value sub(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value neg() {

		throw new InvalidParameterException();
	}

	@Override
	public Value lt(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value lEq(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value gt(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	public Value gEq(Value arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value andBool(Bool arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value orBool(Bool arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value equBool(Bool arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value addInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value divInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value mulInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value subInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value equInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value posInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value negInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value ltInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value lEqInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value gtInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value gEqInt(Numeric arg) {

		throw new InvalidParameterException();
	}

	@Override
	protected Value nEquInt(Numeric arg) {

		throw new InvalidParameterException();
	}


	@Override
	protected Value nEquBool(Bool arg) {
			return new Bool(true);
	}
}
