package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.interfaces.IVisitorType;

public class Str extends Type{

	@Override
	public String toString(){
		return "string";
	}
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
}
