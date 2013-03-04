package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextWidget extends BaseWidget {

	private static final long serialVersionUID = -132604908899541084L;

	public TextWidget(String description) {
		super(description);
	}

	@Override
	protected Component getControlComponent() {
		JTextField jTextField = new JTextField();
		jTextField.setMinimumSize(new Dimension(250, (int)jTextField.getMinimumSize().getHeight()));
		jTextField.setPreferredSize(jTextField.getMinimumSize());
		return jTextField;
	}

}