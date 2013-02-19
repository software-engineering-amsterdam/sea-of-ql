package org.uva.sea.ql.ast.nodes.values;

import java.security.InvalidParameterException;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Bool extends Value {

	
	private final boolean value;

	public Bool(boolean val) {
		this.value = val;
	}
	
	@Override
	public String toString() {
		return this.value+"";
	}
	
	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public Boolean getValue(){
		return this.value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new BoolType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value equ(Value arg) {
		return arg.equBool(this);
	}

	@Override
	public Value and(Value arg) {
		return arg.andBool(this);
	}

	@Override
	public Value or(Value arg) {
		return arg.orBool(this);
	}

	@Override
	public Value not() { //Value val
		return notBool(this);
	}
	
	public Value nEqu(Value arg){
		return arg.nEquBool(this);//  arg.notBool(this);
	}
	
	protected Value nEquBool(Bool arg){
		return new Bool(arg.getValue() != getValue());
	}
	
	

	// INTERNAL
	protected Value andBool(Bool arg) {
		return new Bool(arg.getValue() && getValue());
	}

	protected Value orBool(Bool arg) {
		return new Bool(arg.getValue() || getValue());
	}

	protected Value equBool(Bool arg) {
		return new Bool(arg.getValue() == getValue());
	}

	protected Value notBool(Bool arg) {
		return new Bool(!arg.getValue());
	}

	
	@Override
	public Value add(Value arg) {
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

}
