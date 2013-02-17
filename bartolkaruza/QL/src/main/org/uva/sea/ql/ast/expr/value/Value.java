package org.uva.sea.ql.ast.expr.value;

import org.uva.sea.ql.ast.expr.grouping.Expr;
import org.uva.sea.ql.ast.expr.type.Type;
import org.uva.sea.ql.symbol.SymbolTable;

public abstract class Value extends Expr {

	private static final long serialVersionUID = 2298977319619744862L;
	
	protected Value(int lineNumber) {
		super(lineNumber);
	}
	
	public abstract Object getRawValue();
	
	public abstract void setValue(Object value);
	
	@Override
	public Value evaluate() {
		return this;
	}
	
	@Override
	public boolean isCompatibleToType(Type type, SymbolTable table) {
		return type.isCompatibleTo(type);
	}
	
	@Override
	protected Type getLeastUpperBoundsType(SymbolTable table) {
		return typeOf(table);
	}

	public Value add(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value and(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value geq(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value leq(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value lt(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value neq(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value or(Value value) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value addMon(Money value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divMon(Money value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulMon(Money value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subMon(Money value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value geqInt(Int value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value gtInt(Int value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value leqInt(Int value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value ltInt(Int value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value eqInt(Int value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value neqInt(Int value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value geqMon(Money value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value gtMon(Money value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value leqMon(Money value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value ltMon(Money value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value eqMon(Money value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value neqMon(Money value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value addString(Text value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value eqString(Text value) {
		throw new UnsupportedOperationException();
	}
	
	protected Value andBool(Bool value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value orBool(Bool value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value eqBool(Bool value) {
		throw new UnsupportedOperationException(); 
	}
	
	protected Value neqBool(Bool value) {
		throw new UnsupportedOperationException(); 
	}

}
