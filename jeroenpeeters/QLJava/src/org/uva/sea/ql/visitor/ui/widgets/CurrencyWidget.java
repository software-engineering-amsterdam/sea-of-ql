package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Component;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyWidget extends FormattedTextWidget {

	private static final long serialVersionUID = -132604908899541084L;

	public CurrencyWidget(String description) {
		super(description);
	}

	@Override
	protected Component getControlComponent() {
		DecimalFormat decimalFormat = new DecimalFormat("0.##");
		
		decimalFormat.setCurrency(Currency.getInstance(Locale.getDefault()));
		return super.getControlComponent(decimalFormat);
	}

}