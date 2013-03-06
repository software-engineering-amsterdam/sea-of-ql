package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.ast.value.Value;

public class Numeric extends Type {

	public final String Numeric;

	public Numeric() {
		super();
		Numeric = "Numeric Value";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Numeric == null) ? 0 : Numeric.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Numeric other = (Numeric) obj;
		return Numeric.equals(other.Numeric);
	}

	@Override
	public boolean isValidInput(final String input) {
		try {
			// the following throws a number format exception if the value is not convertable
			return input.isEmpty() || Double.valueOf(input) != null;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public Value createValue(final String value) {
		state.assertNotNull(value, "value");
		if (value.isEmpty()) {
			return new NumericValue(0);
		}
		return new NumericValue(Double.valueOf(value));
	}

}
