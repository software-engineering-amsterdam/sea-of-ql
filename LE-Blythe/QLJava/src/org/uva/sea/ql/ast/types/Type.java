package org.uva.sea.ql.ast.types;

public abstract class Type {

	public boolean isDefinedType(){
		return true;
	}
	
	
	public boolean isCompatibleTo(Type t){
		return t.getClass().isInstance(this);
	}
	
	//public abstract boolean isCompatibleTo(Type t);
	
	/*public boolean isCompatibleToInt() { 
		return false;
	}

	
	public boolean isCompatibleToStr() { 
		return false; 
	}
	
	
	public boolean isCompatibleToBool() { 
		return false; 
	}*/
}
