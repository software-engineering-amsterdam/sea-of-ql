package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Str extends Value {

	private final String value;

	@Override
	public boolean isDefined() {
		return value != null;
	}

	public Str(String val) {
		this.value = val;
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
	public String toString() {
		return "Str(" + this.value + ")";
	}

	@Override
	public Value add(Value arg) {

		return null;
	}

	@Override
	public Value and(Value arg) {

		return null;
	}

	@Override
	public Value or(Value arg) {

		return null;
	}

	@Override
	public Value equ(Value arg) {

		return null;
	}

	@Override
	public Value nEqu(Value arg) {

		return null;
	}

	@Override
	public Value not() {

		return null;
	}

	@Override
	protected Value notBool(Bool arg) {

		return null;
	}

	@Override
	public Value pos() {

		return null;
	}

	@Override
	public Value div(Value arg) {

		return null;
	}

	@Override
	public Value mul(Value arg) {

		return null;
	}

	@Override
	public Value sub(Value arg) {

		return null;
	}

	@Override
	public Value neg() {

		return null;
	}

	@Override
	public Value lt(Value arg) {

		return null;
	}

	@Override
	public Value lEq(Value arg) {

		return null;
	}

	@Override
	public Value gt(Value arg) {

		return null;
	}

	@Override
	public Value gEq(Value arg) {

		return null;
	}

	@Override
	protected Value andBool(Bool arg) {

		return null;
	}

	@Override
	protected Value orBool(Bool arg) {

		return null;
	}

	@Override
	protected Value equBool(Bool arg) {

		return null;
	}

	@Override
	protected Value addInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value divInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value mulInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value subInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value equInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value posInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value negInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value ltInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value lEqInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value gtInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value gEqInt(Numeric arg) {

		return null;
	}

	@Override
	protected Value nEquInt(Numeric arg) {

		return null;
	}

}
