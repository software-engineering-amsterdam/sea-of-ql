package org.uva.sea.ql.gui.control.input;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.parser.evaluator.result.StrValue;

public class TextField extends InputControl {
	private final JTextField textField;
	
	public TextField() {
		textField = new JTextField();
	}
	
	@Override
	public StrValue getValue() {
		return new StrValue(textField.getText());
	}

	@Override
	public JComponent getWidget() {
		return textField;
	}

}
