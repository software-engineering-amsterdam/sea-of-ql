package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.IVisitorExpr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;

public class Int extends Primitive {

	private int value;
	
	public Int(int n){
		value = n;
	}
	
	
	public Integer getValue(){
		return value;
	}
	
	@Override
	public Type typeOf(Environment<Ident,Type> env){
		return new org.uva.sea.ql.ast.type.IntType();
	}
	
	@Override
	public <T> T accept(IVisitorExpr<T> visitor) {
		return visitor.visit(this);
	}	
	
	@Override
	public String toString(){
		return Integer.toString(value);
	}
}
