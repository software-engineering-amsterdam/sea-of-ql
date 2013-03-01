package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.expressions.LiteralExpression;

public abstract class Value extends LiteralExpression {

	// Logical operations
	
	public Value isEquivalentTo(Value value)                 { throw new UnsupportedOperationException(); }
	public Value isEquivalentOrNotEquivalentTo(Value value)  { throw new UnsupportedOperationException(); }
	
	// Arithmetical operations
	
	public Value add(Value value)                            { throw new UnsupportedOperationException(); }
	public Value divideBy(Value value)                       { throw new UnsupportedOperationException(); }
	public Value multiplyBy(Value value)                     { throw new UnsupportedOperationException(); }
	public Value subtractBy(Value value)                     { throw new UnsupportedOperationException(); }
	
	protected Value addInt(Int value)                        { throw new UnsupportedOperationException(); }
	protected Value divideByInt(Int value)                   { throw new UnsupportedOperationException(); }
	protected Value multiplyByInt(Int value)                 { throw new UnsupportedOperationException(); }
	protected Value subtractByInt(Int value)                 { throw new UnsupportedOperationException(); }
	
	protected Value addMoney(Money value)                    { throw new UnsupportedOperationException(); }
	protected Value divideByMoney(Money value)               { throw new UnsupportedOperationException(); }
	protected Value multiplyByMoney(Money value)             { throw new UnsupportedOperationException(); }
	protected Value subtractByMoney(Money value)             { throw new UnsupportedOperationException(); }

	protected Value addString(Str value)                     { throw new UnsupportedOperationException(); }
	
	// Relational operations
	
	public Value equalsValue(Value value)                    { throw new UnsupportedOperationException(); }
	public Value isGreaterThan(Value value)                  { throw new UnsupportedOperationException(); }
	public Value isGreaterThanOrEqualTo(Value value)         { throw new UnsupportedOperationException(); }
	public Value isLessThan(Value value)                     { throw new UnsupportedOperationException(); }
	public Value isLessThanOrEqualTo(Value value)            { throw new UnsupportedOperationException(); }
	public Value notEqualsValue(Value value)                 { throw new UnsupportedOperationException(); }
	
	protected Value equalsBool(Bool value)                   { throw new UnsupportedOperationException(); }
	protected Value equalsInt(Int value)                     { throw new UnsupportedOperationException(); }
	protected Value equalsMoney(Money value)                 { throw new UnsupportedOperationException(); }
	protected Value equalsString(Str value)                  { throw new UnsupportedOperationException(); }
	
	protected Value notEqualsBool(Bool value)                { throw new UnsupportedOperationException(); }
	protected Value notEqualsInt(Int value)                  { throw new UnsupportedOperationException(); }
	protected Value notEqualsMoney(Money value)              { throw new UnsupportedOperationException(); }
	protected Value notEqualsString(Str value)               { throw new UnsupportedOperationException(); }
	
	protected Value isGreaterThanInt(Int value)              { throw new UnsupportedOperationException(); }
	protected Value isGreaterThanMoney(Money value)          { throw new UnsupportedOperationException(); }
	protected Value isGreaterThanOrEqualToInt(Int value)     { throw new UnsupportedOperationException(); }
	protected Value isGreaterThanOrEqualToMoney(Money value) { throw new UnsupportedOperationException(); }
	protected Value isLessThanInt(Int value)                 { throw new UnsupportedOperationException(); }
	protected Value isLessThanMoney(Money value)             { throw new UnsupportedOperationException(); }
	protected Value isLessThanOrEqualToInt(Int value)        { throw new UnsupportedOperationException(); }
	protected Value isLessThanOrEqualToMoney(Money value)    { throw new UnsupportedOperationException(); }
	
	// Unary operations
	
	public Value setToPositive()                             { throw new UnsupportedOperationException(); }
	public Value setToNegative()                             { throw new UnsupportedOperationException(); }
	public Value applyNegation()                             { throw new UnsupportedOperationException(); }
	
}