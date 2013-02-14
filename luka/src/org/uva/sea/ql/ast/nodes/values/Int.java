package org.uva.sea.ql.ast.nodes.values;

import java.util.Map;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.Visitor;

public class Int extends Value {

	private final int value;

	public Int(int val) {
		this.value = val;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntType();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value equ(Value arg) {
		return arg.equ(this);
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
	public Value pos(Value arg) {
		return posInt(this);
	}

	@Override
	public Value neg() {
		return negInt(this);
	}

	public Value nEqu(Value arg){
		return arg.nEquInt(this);
	}
	
	protected Value nEquInt(Int arg){
		return new Bool(arg.getValue() != getValue());
	}
	

	// INTERNAL
	@Override
	protected Value addInt(Int arg) {
		return new Int(arg.getValue() + getValue());
	}

	@Override
	protected Value negInt(Int arg) {
		return new Int(-arg.getValue());
	}
	
	@Override
	protected Value subInt(Int arg) {
		return new Int(arg.getValue() - getValue());
	}

	@Override
	protected Value mulInt(Int arg) {
		return new Int(arg.getValue() * getValue());
	}

	@Override
	protected Value divInt(Int arg) {
		return new Int(arg.getValue() / getValue());
	}

	@Override
	protected Value equInt(Int arg) {
		return new Bool(arg.getValue() == getValue());
	}

	@Override
	protected Value ltInt(Int arg) {
		return new Bool(arg.getValue() < getValue());
	}

	@Override
	protected Value lEqInt(Int arg) {
		return new Bool(arg.getValue() <= getValue());
	}

	@Override
	protected Value gtInt(Int arg) {
		return new Bool(arg.getValue() > getValue());
	}

	@Override
	protected Value gEqInt(Int arg) {
		return new Bool(arg.getValue() >= getValue());
	}
	
	@Override
	public String toString() {
		return "Int("+this.value+")";
	}

}
