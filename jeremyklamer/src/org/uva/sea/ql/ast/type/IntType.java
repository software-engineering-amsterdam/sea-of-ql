package org.uva.sea.ql.ast.type;

public class IntType extends Numeric{

	public IntType(){
		
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
}
