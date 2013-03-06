package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.exp.ExpressionVisitor;
import org.uva.sea.ql.ast.exp.Numeric;

public class NumericValue extends Value {

	private final double value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public NumericValue(final double value) {
		super();
		this.value = value;
		state.assertNotNull(this.value, "NumericValue.value");
	}

	public double getValue() {
		return value;
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new Numeric();
	}

	@Override
	public String toString() {
		return "IntegerValue [value=" + value + ", Type=" + getType() + "]";
	}

	@Override
	public String getAsString() {
		return String.valueOf(value);
	}

}
