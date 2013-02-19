package org.uva.sea.ql.ast.nodes.values;

import java.security.InvalidParameterException;

public abstract class Numeric extends Value {

	protected  Number value;

	public Numeric() { 
	}

	@Override
	public String toString() {
		return "Numeric value ("+this.value+")";
	}
	@Override
	public boolean isDefined() {
		return true;
	}

	public abstract Number getValue();

	@Override
	public Value equ(Value arg) {
		return arg.equInt(this);
	}

	@Override
	public Value add(Value arg) {
		return arg.addInt(this);
	}

	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}

	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}

	@Override
	public Value lt(Value arg) {
		return arg.ltInt(this);
	}

	@Override
	public Value lEq(Value arg) {
		return arg.lEqInt(this);
	}

	@Override
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}

	@Override
	public Value gEq(Value arg) {
		return arg.gEqInt(this);
	}

	@Override
	public Value neg() {
		return negInt(this);
	}

	@Override
	public Value nEqu(Value arg) {
		return arg.nEquInt(this);
	}

	@Override
	protected Value nEquInt(Numeric arg) {
		return new Bool(arg.getValue() != getValue());
	}

	@Override
	protected abstract Value addInt(Numeric arg);

	@Override
	protected abstract Value negInt(Numeric arg);

	@Override
	protected abstract Value subInt(Numeric arg);

	@Override
	protected abstract Value mulInt(Numeric arg);

	@Override
	protected abstract Value divInt(Numeric arg);

	@Override
	protected abstract Value equInt(Numeric arg);

	@Override
	protected abstract Value ltInt(Numeric arg);

	@Override
	protected abstract Value lEqInt(Numeric arg);

	@Override
	protected abstract Value gtInt(Numeric arg);

	@Override
	protected abstract Value posInt(Numeric arg);

	@Override
	protected abstract Value gEqInt(Numeric arg);

	@Override
	public Value and(Value arg) {
		throw new InvalidParameterException();
	}

	@Override
	public Value or(Value arg) {
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
	protected Value notBool(Bool arg) {
		throw new InvalidParameterException();
	}

	@Override
	public Value pos() {
		throw new InvalidParameterException();
	}

	public Value not() {
		throw new InvalidParameterException();
	}

}
