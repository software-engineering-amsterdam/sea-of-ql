package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.Value;

public class Bools extends Type {

	private final String booleanValue;

	public Bools() {
		super();
		booleanValue = "Boolean Value";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((booleanValue == null) ? 0 : booleanValue.hashCode());
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
		Bools other = (Bools) obj;
		return booleanValue.equals(other.booleanValue);
	}

	@Override
	public boolean isValidInput(final String input) {
		return input != null
				&& (input.equalsIgnoreCase("true") || input
						.equalsIgnoreCase("false"));
	}

	@Override
	public Value createValue(final String value) {
		state.assertNotNull(value, "value");
		if (value.equals("true")) {
			return new BooleanValue(true);
		} else {
			return new BooleanValue(false);
		}
	}

}
