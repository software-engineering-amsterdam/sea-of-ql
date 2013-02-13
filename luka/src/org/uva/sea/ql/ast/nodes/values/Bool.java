package org.uva.sea.ql.ast.nodes.values;

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

	public boolean getValue() {
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
	public Value not() {
		return notBool(this);
	}
	
	public Value nEqu(Value arg){
		return arg.notBool(this);
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

}
