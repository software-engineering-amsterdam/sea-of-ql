package org.uva.sea.ql.visitor.eval.value;

public class Money extends AbstractValue {

	// TODO: Convert to BigDecimal
	private final float value;

	public Money(float value) {
		this.value = value;
	}

	public float getValue() {
		return this.value;
	}

	@Override
	public AbstractValue neg() {
		return new Money(-this.getValue());
	}

	@Override
	public AbstractValue pos() {
		return new Money(Math.abs(this.getValue()));
	}

	@Override
	public AbstractValue add(AbstractValue value) {
		return value.addMoney(this);
	}

	@Override
	protected AbstractValue addInt(Int value) {
		return new Money(value.getValue() + this.getValue());
	}

	@Override
	protected AbstractValue addMoney(Money value) {
		return new Money(value.getValue() + this.getValue());
	}

	@Override
	public AbstractValue div(AbstractValue value) {
		return value.divMoney(this);
	}

	@Override
	protected AbstractValue divInt(Int value) {
		return new Money(value.getValue() / this.getValue());
	}

	@Override
	protected AbstractValue divMoney(Money value) {
		return new Money(value.getValue() / this.getValue());
	}

	@Override
	public AbstractValue mul(AbstractValue value) {
		return value.mulMoney(this);
	}

	@Override
	protected AbstractValue mulInt(Int value) {
		return new Money(value.getValue() * this.getValue());
	}

	@Override
	protected AbstractValue mulMoney(Money value) {
		return new Money(value.getValue() * this.getValue());
	}

	@Override
	public AbstractValue sub(AbstractValue value) {
		return value.subMoney(this);
	}

	@Override
	protected AbstractValue subInt(Int value) {
		return new Money(value.getValue() - this.getValue());
	}

	@Override
	protected AbstractValue subMoney(Money value) {
		return new Money(value.getValue() - this.getValue());
	}

	@Override
	public AbstractValue eq(AbstractValue value) {
		return value.eqMoney(this);
	}

	@Override
	public AbstractValue eqInt(Int value) {
		return new Bool(value.getValue() == this.getValue());
	}

	@Override
	public AbstractValue eqMoney(Money value) {
		return new Bool(value.getValue() == this.getValue());
	}

	@Override
	public AbstractValue neq(AbstractValue value) {
		return value.neqMoney(this);
	}

	@Override
	public AbstractValue neqInt(Int value) {
		return new Bool(value.getValue() != this.getValue());
	}

	@Override
	public AbstractValue neqMoney(Money value) {
		return new Bool(value.getValue() != this.getValue());
	}

	@Override
	public AbstractValue geq(AbstractValue value) {
		return value.geqMoney(this);
	}

	@Override
	public AbstractValue geqInt(Int value) {
		return new Bool(value.getValue() >= this.getValue());
	}

	@Override
	public AbstractValue geqMoney(Money value) {
		return new Bool(value.getValue() >= this.getValue());
	}

	@Override
	public AbstractValue gt(AbstractValue value) {
		return value.gtMoney(this);
	}

	@Override
	public AbstractValue gtInt(Int value) {
		return new Bool(value.getValue() > this.getValue());
	}

	@Override
	public AbstractValue gtMoney(Money value) {
		return new Bool(value.getValue() > this.getValue());
	}

	@Override
	public AbstractValue leq(AbstractValue value) {
		return value.leqMoney(this);
	}

	@Override
	public AbstractValue leqInt(Int value) {
		return new Bool(value.getValue() <= this.getValue());
	}

	@Override
	public AbstractValue leqMoney(Money value) {
		return new Bool(value.getValue() <= this.getValue());
	}

	@Override
	public AbstractValue lt(AbstractValue value) {
		return value.ltMoney(this);
	}

	@Override
	public AbstractValue ltInt(Int value) {
		return new Bool(value.getValue() < this.getValue());
	}

	@Override
	public AbstractValue ltMoney(Money value) {
		return new Bool(value.getValue() < this.getValue());
	}

}
