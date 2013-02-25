package org.uva.sea.ql.runtime.ui.swing;

import java.text.NumberFormat;

import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.runtime.values.IntegerValue;
import org.uva.sea.ql.runtime.values.Value;

class SwingIntegerControl extends SwingNumericControl {

	private static final NumberFormat INTEGER_FORMAT = NumberFormat
			.getIntegerInstance();

	protected SwingIntegerControl(final Variable variable) {
		super(variable, INTEGER_FORMAT);
	}

	@Override
	void onUIValueChanged(final String value) {
		Value result;
		try {
			final Long longValue = Long.parseLong(value.replace(",", ""));
			result = new IntegerValue(longValue);
		} catch (final NumberFormatException ex) {
			result = Value.UNSET_VALUE;
		}

		this.getVariable().setValue(result);
	}
}
