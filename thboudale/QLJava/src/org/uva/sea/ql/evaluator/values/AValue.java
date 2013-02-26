package org.uva.sea.ql.evaluator.values;

public abstract class AValue {

	public abstract Object getValue();
	
	public AValue add(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue sub(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue mul(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue div(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue and(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue or(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue eq(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue neq(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue gt(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue geq(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue lt(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	public AValue leq(AValue arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public AValue pos() {
		throw new UnsupportedOperationException();
	}
	
	public AValue neg() {
		throw new UnsupportedOperationException();
	}
	
	public AValue not() {
		throw new UnsupportedOperationException();
	}
	
	
	
	protected AValue addInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue subInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue mulInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue divInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue eqInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue neqInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue gtInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue geqInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue ltInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue leqInt(IntValue arg) {
		throw new UnsupportedOperationException();
	}
	
	
	
	protected AValue andBool(BoolValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue orBool(BoolValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue eqBool(BoolValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue neqBool(BoolValue arg) {
		throw new UnsupportedOperationException();
	}
	
	
	
	protected AValue eqStr(StrValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected AValue neqStr(StrValue arg) {
		throw new UnsupportedOperationException();
	}
}