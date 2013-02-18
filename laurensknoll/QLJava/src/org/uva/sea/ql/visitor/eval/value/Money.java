package org.uva.sea.ql.visitor.eval.value;

import java.math.BigDecimal;

public class Money extends AbstractValue {

	public static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;
	private final BigDecimal value;

	public Money(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	@Override
	public AbstractValue neg() {
		return new Money(this.value.negate());
	}

	@Override
	public AbstractValue pos() {
		return new Money(this.value.abs());
	}

	@Override
	public AbstractValue add(AbstractValue value) {
		return value.addMoney(this);
	}

	@Override
	protected AbstractValue addInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Money(intAsBigDecimal.add(this.value));
	}

	@Override
	protected AbstractValue addMoney(Money value) {
		return new Money(value.getValue().add(this.value));
	}

	@Override
	public AbstractValue div(AbstractValue value) {
		return value.divMoney(this);
	}

	@Override
	protected AbstractValue divInt(Int value) {
		if (this.value.compareTo(new BigDecimal(0)) == 0) {
			// Prevent division by zero.
			return new Money(this.value);
		} else {
			BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
			return new Money(intAsBigDecimal.divide(this.value,
					Money.ROUNDING_MODE));
		}
	}

	@Override
	protected AbstractValue divMoney(Money value) {
		if (this.value.compareTo(new BigDecimal(0)) == 0) {
			// Prevent division by zero.
			return new Money(this.value);
		} else {
			return new Money(value.getValue().divide(this.value,
					Money.ROUNDING_MODE));
		}
	}

	@Override
	public AbstractValue mul(AbstractValue value) {
		return value.mulMoney(this);
	}

	@Override
	protected AbstractValue mulInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Money(intAsBigDecimal.multiply(this.value));
	}

	@Override
	protected AbstractValue mulMoney(Money value) {
		return new Money(value.getValue().multiply(this.value));
	}

	@Override
	public AbstractValue sub(AbstractValue value) {
		return value.subMoney(this);
	}

	@Override
	protected AbstractValue subInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Money(intAsBigDecimal.subtract(this.value));
	}

	@Override
	protected AbstractValue subMoney(Money value) {
		return new Money(value.getValue().subtract(this.value));
	}

	@Override
	public AbstractValue eq(AbstractValue value) {
		return value.eqMoney(this);
	}

	@Override
	public AbstractValue eqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.value) == 0);
	}

	@Override
	public AbstractValue eqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.value) == 0);
	}

	@Override
	public AbstractValue neq(AbstractValue value) {
		return value.neqMoney(this);
	}

	@Override
	public AbstractValue neqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.value) != 0);
	}

	@Override
	public AbstractValue neqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.value) != 0);
	}

	@Override
	public AbstractValue geq(AbstractValue value) {
		return value.geqMoney(this);
	}

	@Override
	public AbstractValue geqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.value) >= 0);
	}

	@Override
	public AbstractValue geqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.value) >= 0);
	}

	@Override
	public AbstractValue gt(AbstractValue value) {
		return value.gtMoney(this);
	}

	@Override
	public AbstractValue gtInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.value) == 1);
	}

	@Override
	public AbstractValue gtMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.value) == 1);
	}

	@Override
	public AbstractValue leq(AbstractValue value) {
		return value.leqMoney(this);
	}

	@Override
	public AbstractValue leqInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.value) <= 0);
	}

	@Override
	public AbstractValue leqMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.value) <= 0);
	}

	@Override
	public AbstractValue lt(AbstractValue value) {
		return value.ltMoney(this);
	}

	@Override
	public AbstractValue ltInt(Int value) {
		BigDecimal intAsBigDecimal = new BigDecimal(value.getValue());
		return new Bool(intAsBigDecimal.compareTo(this.value) == -1);
	}

	@Override
	public AbstractValue ltMoney(Money value) {
		return new Bool(value.getValue().compareTo(this.value) == -1);
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
