package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.expressions.Expression;

public abstract class Value extends Expression {

	public boolean isStringValue()                         { return false; }
	public boolean isBooleanValue()                        { return false; }
	public boolean isNumericValue()                        { return false; }
	
	// Logical operations
	
	public Value and(Value value)                          { throw new UnsupportedOperationException(); }
	public Value or(Value value)                           { throw new UnsupportedOperationException(); }
	
	// Arithmetical operations
	
	public Value add(Value value)                          { throw new UnsupportedOperationException(); }
	public Value div(Value value)                          { throw new UnsupportedOperationException(); }
	public Value mul(Value value)                          { throw new UnsupportedOperationException(); }
	public Value sub(Value value)                          { throw new UnsupportedOperationException(); }
	
	protected Value addInt(Int value)                      { throw new UnsupportedOperationException(); }
	protected Value divInt(Int value)                      { throw new UnsupportedOperationException(); }
	protected Value mulInt(Int value)                      { throw new UnsupportedOperationException(); }
	protected Value subInt(Int value)                      { throw new UnsupportedOperationException(); }
	
	protected Value addMoney(Money value)                  { throw new UnsupportedOperationException(); }
	protected Value divMoney(Money value)                  { throw new UnsupportedOperationException(); }
	protected Value mulMoney(Money value)                  { throw new UnsupportedOperationException(); }
	protected Value subMoney(Money value)                  { throw new UnsupportedOperationException(); }

	protected Value addString(Str value)                   { throw new UnsupportedOperationException(); }
	
	// Relational operations
	
	public Value equalsValue(Value value)                  { throw new UnsupportedOperationException(); }
	public Value greaterThan(Value value)                  { throw new UnsupportedOperationException(); }
	public Value greaterThanOrEqualTo(Value value)         { throw new UnsupportedOperationException(); }
	public Value lessThan(Value value)                     { throw new UnsupportedOperationException(); }
	public Value lessThanOrEqualTo(Value value)            { throw new UnsupportedOperationException(); }
	public Value notEqualsValue(Value value)               { throw new UnsupportedOperationException(); }
	
	protected Value equalsBool(Bool value)                 { throw new UnsupportedOperationException(); }
	protected Value equalsInt(Int value)                   { throw new UnsupportedOperationException(); }
	protected Value equalsMoney(Money value)               { throw new UnsupportedOperationException(); }
	protected Value equalsString(Str value)                { throw new UnsupportedOperationException(); }
	
	protected Value notEqualsBool(Bool value)              { throw new UnsupportedOperationException(); }
	protected Value notEqualsInt(Int value)                { throw new UnsupportedOperationException(); }
	protected Value notEqualsMoney(Money value)            { throw new UnsupportedOperationException(); }
	protected Value notEqualsString(Str value)             { throw new UnsupportedOperationException(); }
	
	protected Value greaterThanInt(Int value)              { throw new UnsupportedOperationException(); }
	protected Value greaterThanMoney(Money value)          { throw new UnsupportedOperationException(); }
	protected Value greaterThanOrEqualToInt(Int value)     { throw new UnsupportedOperationException(); }
	protected Value greaterThanOrEqualToMoney(Money value) { throw new UnsupportedOperationException(); }
	protected Value lessThanInt(Int value)                 { throw new UnsupportedOperationException(); }
	protected Value lessThanMoney(Money value)             { throw new UnsupportedOperationException(); }
	protected Value lessThanOrEqualToInt(Int value)        { throw new UnsupportedOperationException(); }
	protected Value lessThanOrEqualToMoney(Money value)    { throw new UnsupportedOperationException(); }
	
	// Unary operations
	
	public Value setToPositive()                           { throw new UnsupportedOperationException(); }
	public Value setToNegative()                           { throw new UnsupportedOperationException(); }
	public Value applyNegation()                           { throw new UnsupportedOperationException(); }
	
}