package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Component;
import java.text.NumberFormat;

public class NumberWidget extends FormattedTextWidget {

	private static final long serialVersionUID = -132604908899541084L;

	public NumberWidget(String description) {
		super(description);
	}

	@Override
	protected Component getControlComponent() {
		return super.getControlComponent(NumberFormat.getNumberInstance());
	}

}