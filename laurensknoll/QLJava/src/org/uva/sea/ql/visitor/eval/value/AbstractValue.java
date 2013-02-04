package org.uva.sea.ql.visitor.eval.value;

public abstract class AbstractValue {

	/*
	 * Arithmetic expressions
	 */
	public AbstractValue add(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue div(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue mul(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue sub(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Logical expressions
	 */
	public AbstractValue and(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue eq(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue geq(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue gt(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue leq(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue lt(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue neq(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue or(AbstractValue value) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Boolean Logical expressions
	 */
	protected AbstractValue andBool(Bool value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue orBool(Bool value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue eqBool(Bool value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue neqBool(Bool value) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Integer Logical expressions
	 */
	public AbstractValue eqInt(Int value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue geqInt(Int value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue gtInt(Int value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue leqInt(Int value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue ltInt(Int value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue neqInt(Int value) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Money Logical expressions
	 */
	public AbstractValue eqMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue geqMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue gtMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue leqMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue ltMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	public AbstractValue neqMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Unary expressions
	 */
	public AbstractValue neg() {
		throw new UnsupportedOperationException();
	}

	public AbstractValue not() {
		throw new UnsupportedOperationException();
	}

	public AbstractValue pos() {
		throw new UnsupportedOperationException();
	}

	/*
	 * Integer arithmetic expressions
	 */
	protected AbstractValue addInt(Int value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue divInt(Int value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue mulInt(Int value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue subInt(Int value) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Money arithmetic expressions
	 */
	protected AbstractValue addMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue divMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue mulMoney(Money value) {
		throw new UnsupportedOperationException();
	}

	protected AbstractValue subMoney(Money value) {
		throw new UnsupportedOperationException();
	}

}
