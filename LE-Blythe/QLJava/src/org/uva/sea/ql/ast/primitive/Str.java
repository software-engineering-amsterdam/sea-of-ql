package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.IVisitorExpr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;

public class Str extends Primitive {

	private String value;
	
	public Str(String s){
		value = s;
	}
	
	
	public String getValue(){
		return value;
	}
	
	
	public Type typeOf(Environment env){
		return new org.uva.sea.ql.ast.types.Str();
	}
	
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	// ----------- Generic Comparative-------------------------
	@Override
	public Primitive eq(Primitive arg) {
		return arg.eqStr(this);
	}

	@Override
	public Primitive nEq(Primitive arg) {
		return arg.nEqStr(this);
	}

	// ----------- Str Comparative -------------------------
	@Override
	protected Primitive eqStr(Str arg) {
		return new Bool(this.getValue().equals(arg.getValue()));
	}

	@Override
	protected Primitive nEqStr(Str arg) {
		return new Bool(!this.getValue().equals(arg.getValue()));
	}
}
