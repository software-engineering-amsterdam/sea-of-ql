package org.uva.sea.ql.ast.types;

public abstract class Type {

	public boolean isDefinedType(){
		return true;
	}
	
	
	public boolean isCompatibleTo(Type t){
		return t.getClass().isInstance(this);
	}
	
	
	public abstract String toString();
	
}
