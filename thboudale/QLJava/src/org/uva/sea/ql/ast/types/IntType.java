package org.uva.sea.ql.ast.types;

public class IntType extends AType {
	
	@Override
	public boolean isCompatibleTo(AType t) {
		return t.isCompatibleToInt();
	}
	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
}