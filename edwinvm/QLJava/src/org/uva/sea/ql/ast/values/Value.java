package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.expressions.Expression;

public abstract class Value extends Expression {

	public Value pos()                    { throw new UnsupportedOperationException(); }
	
	public Value and(Value value)         { throw new UnsupportedOperationException(); }
	
	public Value add(Value value)         { throw new UnsupportedOperationException(); }
	
	public Value div(Value value)         { throw new UnsupportedOperationException(); }
	
	public Value mul(Value value)         { throw new UnsupportedOperationException(); }
	
	public Value sub(Value value)         { throw new UnsupportedOperationException(); }
	
	protected Value addInt(Int value)     { throw new UnsupportedOperationException(); }
	
	protected Value divInt(Int value)     { throw new UnsupportedOperationException(); }
	
	protected Value mulInt(Int value)     { throw new UnsupportedOperationException(); }
	
	protected Value subInt(Int value)     { throw new UnsupportedOperationException(); }
	
	protected Value addMoney(Money value) { throw new UnsupportedOperationException(); }
	
	protected Value divMoney(Money value) { throw new UnsupportedOperationException(); }
	
	protected Value mulMoney(Money value) { throw new UnsupportedOperationException(); }
	
	protected Value subMoney(Money value) { throw new UnsupportedOperationException(); }
	
}