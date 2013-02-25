package org.uva.sea.ql.gui.control.input;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.gui.misc.InputSourceDelegate;
import org.uva.sea.ql.parser.evaluator.result.StrValue;

public class TextField extends InputControl {
	private final JTextField textField;
	private DocumentListener documentListener;

	public TextField() {
		textField = new JTextField(5);
	}

	@Override
	public StrValue getValue() {
		return new StrValue(textField.getText());
	}

	@Override
	public JComponent getWidget() {
		return textField;
	}

	@Override
	public void setDelegate(InputSourceDelegate delegate) {
		super.setDelegate(delegate);

		textField.getDocument().removeDocumentListener(documentListener);

		documentListener = new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				signalDelegate();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				signalDelegate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				signalDelegate();
			}
		};

		textField.getDocument().addDocumentListener(documentListener);
	}

}
