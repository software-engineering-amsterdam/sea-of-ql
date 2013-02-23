package org.uva.sea.ql.ast.types;

public class BoolType extends AType {
	
	@Override
	public boolean isCompatibleTo(AType t) {
		return t.isCompatibleToBool();
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
}