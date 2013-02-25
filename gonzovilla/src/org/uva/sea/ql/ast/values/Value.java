package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Value extends Expr {
		
	abstract public Object getValue();

	public Value add(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value andBool(BoolValue value) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value r) {
		return new BoolValue(r.getValue().equals(this.getValue()));
	}

	public Value geq(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value geqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value gtInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value leq(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value leqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value ltInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value r) {
		throw new UnsupportedOperationException();
	}

	protected Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value neq(Value r) {
		return new BoolValue(!(r.getValue().equals(this.getValue())));
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value or(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value orBool(BoolValue value) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value r) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}

}
