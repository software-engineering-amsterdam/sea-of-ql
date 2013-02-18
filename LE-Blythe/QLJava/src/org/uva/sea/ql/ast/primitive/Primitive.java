package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Expr;

public abstract class Primitive extends Expr{
	
	public abstract String toString();

	
	public boolean isDefined(){
		return true;
	}

	//----------- Generic Numeric -------------------------
	public Primitive add(Primitive arg) {
		throw new UnsupportedOperationException();
	}


	public Primitive div(Primitive arg) {
		throw new UnsupportedOperationException();
	}

	
	public Primitive mul(Primitive arg) {
		throw new UnsupportedOperationException();
	}

	
	public Primitive sub(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Primitive pos() {
		throw new UnsupportedOperationException();
	}
	
	
	public Primitive neg() {
		throw new UnsupportedOperationException();
	}

	//----------- Generic Boolean -------------------------
	public Primitive and(Primitive arg) {
		throw new UnsupportedOperationException();
	}

	
	public Primitive or(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	

	public Primitive not() {
		throw new UnsupportedOperationException();
	}
	
	//----------- Generic Comparative-------------------------
	public Primitive eq(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Primitive gEq(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Primitive gt(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Primitive lEq(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Primitive lt(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	

	public Primitive nEq(Primitive arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Int Numeric-------------------------
	protected Primitive addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	
	protected Primitive divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	
	protected Primitive mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	
	protected Primitive subInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Int Comparative -------------------------
	protected Primitive eqInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive nEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive gEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive gtInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive lEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive ltInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Bool Boolean -------------------------
	protected Primitive andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Bool Comparative -------------------------
	protected Primitive eqBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive nEqBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Str Comparative -------------------------
	protected Primitive eqStr(Str arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Primitive nEqStr(Str arg) {
		throw new UnsupportedOperationException();
	}
}
