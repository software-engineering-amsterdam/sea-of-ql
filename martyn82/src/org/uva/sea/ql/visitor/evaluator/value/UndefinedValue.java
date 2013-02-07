package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.UndefinedType;

/**
 * Represents an undefined value.
 */
public class UndefinedValue extends Value {
	/**
	 * Holds the undefined value.
	 */
	public final static UndefinedValue UNDEFINED = new UndefinedValue();

	/**
	 * Hidden constructor.
	 */
	private UndefinedValue() {
	}

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
