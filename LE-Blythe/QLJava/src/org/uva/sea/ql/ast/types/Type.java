package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.IVisitorType;


public abstract class Type {

	public boolean isDefinedType(){
		return true;
	}
	
	
	public boolean isCompatibleTo(Type t){
		return t.getClass().isInstance(this);
	}
	
	
	public abstract String toString();
	
	public abstract <T> T accept(IVisitorType<T> visitor);
}
