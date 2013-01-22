package org.uva.sea.ql.ast.types;


public class BooleanType extends TypeDescription {

	public BooleanType() {
		super("boolean");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
}
