package org.uva.sea.ql.visitor.eval.value;

import java.math.BigDecimal;

public class Money extends AbstractValue {

	private final int roundingMode;
	private final BigDecimal value;

	public Money(BigDecimal value) {
		this.value = value;
		this.roundingMode = BigDecimal.ROUND_HALF_EVEN;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public int getRoundingMode() {
		return this.roundingMode;
	}

	@Override
	public AbstractValue neg() {
		return new Money(this.getValue().negate());
	}

	@Override
	public AbstractValue pos() {
		return new Money(this.getValue().abs());
	}

	@Override
	public AbstractValue add(AbstractValue value) {
		return value.addMoney(this);
	}

	@Override
	protected AbstractValue addInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Money(intAsBigDecimal.add(this.getValue()));
	}

	@Override
	protected AbstractValue addMoney(Money value) {
		return new Money(value.getValue().add(this.getValue()));
	}

	@Override
	public AbstractValue div(AbstractValue value) {
		return value.divMoney(this);
	}

	@Override
	protected AbstractValue divInt(Int value) {
		if (this.getValue().compareTo(new BigDecimal(0)) == 0) {
			// Prevent division by zero.
			return new Money(this.getValue());
		} else {
			BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
			return new Money(intAsBigDecimal.divide(this.getValue(),
					this.roundingMode));
		}
	}

	@Override
	protected AbstractValue divMoney(Money value) {
		if (this.getValue().compareTo(new BigDecimal(0)) == 0) {
			// Prevent division by zero.
			return new Money(this.getValue());
		} else {
			return new Money(value.getValue().divide(this.getValue(),
					this.roundingMode));
		}
	}

	@Override
	public AbstractValue mul(AbstractValue value) {
		return value.mulMoney(this);
	}

	@Override
	protected AbstractValue mulInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Money(intAsBigDecimal.multiply(this.getValue()));
	}

	@Override
	protected AbstractValue mulMoney(Money value) {
		return new Money(value.getValue().multiply(this.getValue()));
	}

	@Override
	public AbstractValue sub(AbstractValue value) {
		return value.subMoney(this);
	}

	@Override
	protected AbstractValue subInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Money(intAsBigDecimal.subtract(this.getValue()));
	}

	@Override
	protected AbstractValue subMoney(Money value) {
		return new Money(value.getValue().subtract(this.getValue()));
	}

	@Override
	public AbstractValue eq(AbstractValue value) {
		return value.eqMoney(this);
	}

	@Override
	public AbstractValue eqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.getValue()) == 0);
	}

	@Override
	public AbstractValue eqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.getValue()) == 0);
	}

	@Override
	public AbstractValue neq(AbstractValue value) {
		return value.neqMoney(this);
	}

	@Override
	public AbstractValue neqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.getValue()) != 0);
	}

	@Override
	public AbstractValue neqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.getValue()) != 0);
	}

	@Override
	public AbstractValue geq(AbstractValue value) {
		return value.geqMoney(this);
	}

	@Override
	public AbstractValue geqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.getValue()) >= 0);
	}

	@Override
	public AbstractValue geqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.getValue()) >= 0);
	}

	@Override
	public AbstractValue gt(AbstractValue value) {
		return value.gtMoney(this);
	}

	@Override
	public AbstractValue gtInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.getValue()) == 1);
	}

	@Override
	public AbstractValue gtMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.getValue()) == 1);
	}

	@Override
	public AbstractValue leq(AbstractValue value) {
		return value.leqMoney(this);
	}

	@Override
	public AbstractValue leqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.getValue()) <= 0);
	}

	@Override
	public AbstractValue leqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.getValue()) <= 0);
	}

	@Override
	public AbstractValue lt(AbstractValue value) {
		return value.ltMoney(this);
	}

	@Override
	public AbstractValue ltInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.getValue()) == -1);
	}

	@Override
	public AbstractValue ltMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.getValue()) == -1);
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Money)) {
			return false;
		}

		Money value = (Money) obj;
		return this.value.compareTo(value.getValue()) == 0;
	}

	@Override
	public java.lang.String toString() {
		return this.value.toString();
	}

}
