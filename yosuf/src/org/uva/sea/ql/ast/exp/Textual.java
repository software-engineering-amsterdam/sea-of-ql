package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.value.StringValue;
import org.uva.sea.ql.ast.value.Value;

public class Textual extends Nature {

	private final String textualValue;

	public Textual() {
		super();
		textualValue = "Textual Value";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((textualValue == null) ? 0 : textualValue.hashCode());
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
		Textual other = (Textual) obj;
		return textualValue.equals(other.textualValue);
	}

	@Override
	public boolean isValidInput(final String input) {
		return input != null;
	}

	@Override
	public Value createValue(final String value) {
		state.assertNotNull(value, "value");
		return new StringValue(value);
	}

}
