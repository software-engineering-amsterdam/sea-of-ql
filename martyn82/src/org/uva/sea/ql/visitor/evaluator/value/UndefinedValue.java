package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.UndefinedType;

public class UndefinedValue extends Value {
	public final static UndefinedValue UNDEFINED = new UndefinedValue();

	private UndefinedValue() {}

	@Override
	public UndefinedType getType() {
		return new UndefinedType();
	}

	@Override
	public Void getValue() {
		return null;
	}

	@Override
	public boolean isDefined() {
		return false;
	}
}
