package org.uva.sea.ql.ast.nodes.values;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Arr extends Value {

	private List<Value> values;
	private Type type;
	private int currentValue = 0;

	public Arr(List<Value> values, Type type) {
		this.type = type;
		this.values = values;
	}

	public Type getType(){
		return this.type;
	}
	@Override
	public Object getValue() {
		return this.values.get(this.currentValue);
	}

	public List<Value> getValues() {
		return this.values;
	}

	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public Value add(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value and(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value or(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value equ(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value nEqu(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value not() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value andBool(Bool arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value orBool(Bool arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value equBool(Bool arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value notBool(Bool arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value pos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value div(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value mul(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value sub(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value neg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value lt(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value lEq(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value gt(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value gEq(Value arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value addInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value divInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value mulInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value subInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value equInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value posInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value negInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value ltInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value lEqInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value gtInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value gEqInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Value nEquInt(Numeric arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

}
