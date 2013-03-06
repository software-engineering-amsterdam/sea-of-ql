package org.uva.sea.ql.runtime.ui.swing;

import java.text.NumberFormat;

import org.uva.sea.ql.runtime.RuntimeValue;
import org.uva.sea.ql.runtime.values.MoneyValue;
import org.uva.sea.ql.runtime.values.Value;

public class SwingMoneyControl extends SwingNumericControl {

	private static final NumberFormat MONEY_FORMAT;

	static {
		MONEY_FORMAT = NumberFormat.getNumberInstance();
		MONEY_FORMAT.setMaximumFractionDigits(2);
		MONEY_FORMAT.setMinimumFractionDigits(2);
	}

	protected SwingMoneyControl(final RuntimeValue variable) {
		super(variable, MONEY_FORMAT);
	}

	@Override
	void onUIValueChanged(String value) {
		Value result;
		try {
			value = value.replaceAll(",", "");
			final Double doubleValue = Double.parseDouble(value);
			result = new MoneyValue(doubleValue);
		} catch (final NumberFormatException ex) {
			result = Value.UNSET_VALUE;
		}

		this.getVariable().setValue(result);
	}

}
