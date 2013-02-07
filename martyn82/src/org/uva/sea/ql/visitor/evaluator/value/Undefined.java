package org.uva.sea.ql.visitor.evaluator.value;

/**
 * Represents an undefined value.
 */
public class Undefined extends Value {
	/**
	 * Holds the undefined value.
	 */
	public final static Undefined UNDEFINED = new Undefined();

	/**
	 * Hidden constructor.
	 */
	private Undefined() {
	}

	@Override
	public org.uva.sea.ql.ast.type.Undefined getType() {
		return new org.uva.sea.ql.ast.type.Undefined();
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
