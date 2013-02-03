package org.uva.sea.ql.ast.types;


public class BoolType extends Type {
	
	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

}
