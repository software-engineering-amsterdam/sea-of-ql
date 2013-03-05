package org.uva.sea.ql.ast.types;

public class IntType extends NumericType {
	
	@Override
	public boolean isCompatibleTo(Type t){
		return t.isCompatibleToInt();
	}

}
