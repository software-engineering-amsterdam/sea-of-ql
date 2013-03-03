package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Dimension;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;

public abstract class FormattedTextWidget extends BaseWidget {

	private static final long serialVersionUID = -132604908899541084L;

	public FormattedTextWidget(String description) {
		super(description);
	}

	protected JFormattedTextField getControlComponent(final Format format) {
		JFormattedTextField jTextField = new JFormattedTextField(format);
		
		jTextField.setMinimumSize(new Dimension(250, (int)jTextField.getMinimumSize().getHeight()));
		jTextField.setPreferredSize(jTextField.getMinimumSize());
		
		return jTextField;
	}

}