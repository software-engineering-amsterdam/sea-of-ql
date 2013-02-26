package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.IVisitorType;

public class Str extends Type{

	@Override
	public String toString(){
		return "string";
	}
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() {
		return true;
	}
}
