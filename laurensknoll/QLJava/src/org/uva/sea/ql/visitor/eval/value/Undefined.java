package org.uva.sea.ql.visitor.eval.value;

public class Undefined extends AbstractValue {

	public static Undefined UNDEFINED = getUndefined();

	private static Undefined getUndefined() {
		return new Undefined();
	}

	public AbstractValue add(AbstractValue value) {
		return Undefined.UNDEFINED;
	}

	public AbstractValue div(AbstractValue value) {
		return Undefined.UNDEFINED;
	}

	public AbstractValue mul(AbstractValue value) {
		return Undefined.UNDEFINED;
	}

	public AbstractValue sub(AbstractValue value) {
		return Undefined.UNDEFINED;
	}

	public AbstractValue and(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue eq(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue geq(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue gt(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue leq(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue lt(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue neq(AbstractValue value) {
		return new Bool(false);
	}

	public AbstractValue or(AbstractValue value) {
		return value;
	}

	protected AbstractValue andBool(Bool value) {
		return new Bool(false);
	}

	protected AbstractValue orBool(Bool value) {
		return value;
	}

	public AbstractValue eqBool(Bool value) {
		return new Bool(false);
	}

	public AbstractValue neqBool(Bool value) {
		return new Bool(false);
	}

	public AbstractValue eqInt(Int value) {
		return new Bool(false);
	}

	public AbstractValue geqInt(Int value) {
		return new Bool(false);
	}

	public AbstractValue gtInt(Int value) {
		return new Bool(false);
	}

	public AbstractValue leqInt(Int value) {
		return new Bool(false);
	}

	public AbstractValue ltInt(Int value) {
		return new Bool(false);
	}

	public AbstractValue neqInt(Int value) {
		return new Bool(false);
	}

	public AbstractValue eqMoney(Money value) {
		return new Bool(false);
	}

	public AbstractValue geqMoney(Money value) {
		return new Bool(false);
	}

	public AbstractValue gtMoney(Money value) {
		return new Bool(false);
	}

	public AbstractValue leqMoney(Money value) {
		return new Bool(false);
	}

	public AbstractValue ltMoney(Money value) {
		return new Bool(false);
	}

	public AbstractValue neqMoney(Money value) {
		return new Bool(false);
	}

	public AbstractValue neg() {
		return Undefined.UNDEFINED;
	}

	public AbstractValue not() {
		return new Bool(false);
	}

	public AbstractValue pos() {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue addInt(Int value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue divInt(Int value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue mulInt(Int value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue subInt(Int value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue addMoney(Money value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue divMoney(Money value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue mulMoney(Money value) {
		return Undefined.UNDEFINED;
	}

	protected AbstractValue subMoney(Money value) {
		return Undefined.UNDEFINED;
	}

	@Override
	public java.lang.String toString() {
		return "Undefined";
	}

}
