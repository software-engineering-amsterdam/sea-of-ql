package org.uva.sea.ql.ast.datatype;

import org.uva.sea.ql.ast.Visitor;

public class BooleanType extends Datatype {
	private boolean value;
	
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.setDefined();
		this.value = value;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isCompatibleTo(Datatype type) {
		return type.isCompatibleToBoolean();
	}

	public boolean isCompatibleToBoolean() {
		return true;
	}
}
