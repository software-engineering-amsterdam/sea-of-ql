package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.IVisitorType;

public class Undefined extends Type{
	
	@Override
	public boolean isDefinedType(){
		return false;
	}
	

	@Override
	public String toString(){
		return "Undefined";
	}
	
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
}
