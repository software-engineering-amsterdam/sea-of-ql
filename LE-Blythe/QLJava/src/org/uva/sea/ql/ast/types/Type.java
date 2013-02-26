package org.uva.sea.ql.ast.types;



public abstract class Type {

	public abstract String toString();
	public abstract <T> T accept(IVisitorType<T> visitor);
	
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToInt() { 
		return false; 
	}
	
	public boolean isCompatibleToNumeric() { 
		return false; 
	}
	
	public boolean isCompatibleToStr() { 
		return false; 
	}
	
	public boolean isCompatibleToBool() { 
		return false; 
	}
	
	public boolean isCompatibleToMoney() { 
		return false; 
	}
	
	public boolean isDefinedType(){
		return true;
	}
}
