package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.IVisitorExpr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public class Bool extends Primitive {

	private boolean value;
	
	public Bool(boolean b){
		value = b;
	}
	
	
	public boolean getValue(){
		return value;
	}
	
	@Override
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Bool();
	}
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
	
	
	@Override
	public String toString(){
		return Boolean.toString(value);
	}
	
	//----------- Generic Boolean -------------------------
	@Override
	public Primitive and(Primitive arg) {
		return arg.andBool(this);
	}

	
	@Override
	public Primitive or(Primitive arg) {
		return arg.orBool(this);
	}

	@Override
	public Primitive not() {
		return new Bool(!this.getValue());
	}

	// ----------- Generic Comparative-------------------------
	@Override
	public Primitive eq(Primitive arg) {
		return arg.eqBool(this);
	}

	@Override
	public Primitive nEq(Primitive arg) {
		return arg.nEqBool(this);
	}
	
	//----------- Bool Boolean -------------------------
	@Override
	protected Primitive andBool(Bool arg) {
		return new Bool(arg.getValue() && this.getValue());
	}

	@Override
	protected Primitive orBool(Bool arg) {
		return new Bool(arg.getValue() || this.getValue());
	}

	// ----------- Bool Comparative -------------------------
	@Override
	protected Primitive eqBool(Bool arg) {
		return new Bool(arg.getValue() == this.getValue());
	}

	@Override
	protected Primitive nEqBool(Bool arg) {
		return new Bool(arg.getValue() != this.getValue());
	}

}
