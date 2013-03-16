package org.uva.sea.ql.visitor.ui.widgets;

import java.text.DecimalFormat;

import org.uva.sea.ql.valuesystem.IntegerValue;
import org.uva.sea.ql.valuesystem.MoneyValue;
import org.uva.sea.ql.valuesystem.Value;

public class CurrencyWidget extends FormattedTextWidget {

	private static final long serialVersionUID = -132604908899541084L;
	
	public CurrencyWidget(final String description, final WidgetObserver widgetObserver) {
		super(description, widgetObserver, new DecimalFormat("0.##"));
	}

	@Override
	public Value getValue() {
		double val;
		try{
			val = Double.valueOf(this.jFormattedTextfield.getText());
		}catch(NumberFormatException e){
			val = 0;
		}
		return new MoneyValue(val);
	}

}