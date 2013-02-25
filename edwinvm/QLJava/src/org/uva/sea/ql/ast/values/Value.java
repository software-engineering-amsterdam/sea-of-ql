package org.uva.sea.ql.ast.values;

public abstract class Value {
	
	public Value add(Value value)     { throw new UnsupportedOperationException(); }
	
	public Value pos()                { throw new UnsupportedOperationException(); }
	
	public Value div(Value value)     { throw new UnsupportedOperationException(); }
	
	public Value mul(Value value)     { throw new UnsupportedOperationException(); }
	
	public Value sub(Value value)     { throw new UnsupportedOperationException(); }
	
	public Value and(Value value)     { throw new UnsupportedOperationException(); }
	
	protected Value addInt(Int value) { throw new UnsupportedOperationException(); }
	
	protected Value divInt(Int value) { throw new UnsupportedOperationException(); }
	
	protected Value mulInt(Int value) { throw new UnsupportedOperationException(); }
	
	protected Value subInt(Int value) { throw new UnsupportedOperationException(); }
	
}