package org.uva.sea.ql.ast;

public class StringType extends TypeDescription {

	public StringType() {
		super("string");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToString();
	}

	@Override
	public boolean isCompatibleToString() {
		return true;
	}
}
