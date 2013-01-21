package org.uva.sea.ql.ast;

public class LookUpType extends TypeDescription {

	public LookUpType() {
		super("lookup");
	}

	@Override
	public boolean compatibleType(TypeDescription testType) {
		return false;
	}
}
