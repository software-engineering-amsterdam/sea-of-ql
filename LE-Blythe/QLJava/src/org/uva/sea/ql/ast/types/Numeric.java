package org.uva.sea.ql.ast.types;


public class Numeric extends Type{

	@Override
	public String toString(){
		return "numeric";
	}
	
	
	public <T> T accept(IVisitorType<T> visitor){
		return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}
	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}
}
