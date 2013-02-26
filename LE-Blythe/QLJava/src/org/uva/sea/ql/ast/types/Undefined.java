package org.uva.sea.ql.ast.types;


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


	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
}
