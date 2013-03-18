package org.uva.sea.ql.visitor.ui.widgets;

import java.text.NumberFormat;

import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;

public class NumberWidget extends FormattedTextWidget {

	private static final long serialVersionUID = -132604908899541084L;

	public NumberWidget(final String description, final WidgetObserver widgetObserver) {
		super(description, widgetObserver, NumberFormat.getNumberInstance());
	}

	@Override
	public Value getValue() {
		int val;
		try{
			val = Integer.valueOf(this.jFormattedTextfield.getText());
		}catch(NumberFormatException e){
			val = 0;
		}
		return new IntegerValue(val);
	}

}