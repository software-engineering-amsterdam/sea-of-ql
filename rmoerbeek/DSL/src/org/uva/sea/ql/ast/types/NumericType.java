package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.TypeVisitor;

public class NumericType extends Type {
	
	public boolean isCompatibleTo(Type t){
		return t.isCompatibleToNumeric();
	}

	public boolean isCompatibleToNumeric(){
		return true;
	}
	
	public boolean isCompatibleToMoney(){
		return true;
	}
	
	public boolean isCompatibleToInt(){
		return true;
	}

	public String toString() {
		return "numeric";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return null;
	}
}
