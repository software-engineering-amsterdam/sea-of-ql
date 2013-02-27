package org.uva.sea.ql.ast.types;

public class StringType extends AType {

	@Override
	public boolean isCompatibleTo(AType t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() {
		return true;
	}
}