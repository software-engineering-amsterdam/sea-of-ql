package org.uva.sea.ql.ast.datatype;

import org.uva.sea.ql.ast.Visitor;

public class IntegerType extends Datatype {
	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.setDefined();
		this.value = value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Datatype type) {
		return type.isCompatibleToInteger();
	}

	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}
}
