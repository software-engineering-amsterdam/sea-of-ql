package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.IVisitorExpr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
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
	public Type typeOf(Environment<Ident,Type> env){
		return new org.uva.sea.ql.ast.type.BoolType();
	}
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}
		
	@Override
	public String toString(){
		return Boolean.toString(value);
	}
}
