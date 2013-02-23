package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.IVisitorExpr;
import org.uva.sea.ql.util.Environment;

public class Undefined extends Primitive {

	private Type type;
	
	public Undefined(){
		this.type = new org.uva.sea.ql.ast.types.Undefined();
	}
	
	
	public Undefined(Type t){
		this.type = t;
	}


	public boolean isDefined(){
		return false;
	}

	public Type typeOf(Environment env) {
		return type;
	}

	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Undefined";
	}

	// ----------- Generic Numeric -------------------------
	@Override
	public Primitive add(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive div(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive mul(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive sub(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive pos() {
		return new Undefined();
	}

	@Override
	public Primitive neg() {
		return new Undefined();
	}

	// ----------- Generic Boolean -------------------------
	@Override
	public Primitive and(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive or(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive not() {
		return new Undefined();
	}

	// ----------- Generic Comparative-------------------------
	@Override
	public Primitive eq(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive gEq(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive gt(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive lEq(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive lt(Primitive arg) {
		return new Undefined();
	}

	@Override
	public Primitive nEq(Primitive arg) {
		return new Undefined();
	}

	// ----------- Int Numeric-------------------------
	@Override
	protected Primitive addInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive divInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive mulInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive subInt(Int arg) {
		return new Undefined();
	}

	// ----------- Int Comparative -------------------------
	@Override
	protected Primitive eqInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive nEqInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive gEqInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive gtInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive lEqInt(Int arg) {
		return new Undefined();
	}

	@Override
	protected Primitive ltInt(Int arg) {
		return new Undefined();
	}

	// ----------- Bool Boolean -------------------------
	@Override
	protected Primitive andBool(Bool arg) {
		return new Undefined();
	}

	@Override
	protected Primitive orBool(Bool arg) {
		return new Undefined();
	}

	// ----------- Bool Comparative -------------------------
	@Override
	protected Primitive eqBool(Bool arg) {
		return new Undefined();
	}

	@Override
	protected Primitive nEqBool(Bool arg) {
		return new Undefined();
	}

	// ----------- Str Comparative -------------------------
	@Override
	protected Primitive eqStr(Str arg) {
		return new Undefined();
	}

	@Override
	protected Primitive nEqStr(Str arg) {
		return new Undefined();
	}
}
