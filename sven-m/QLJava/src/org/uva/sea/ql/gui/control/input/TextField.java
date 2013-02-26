package org.uva.sea.ql.gui.control.input;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.uva.sea.ql.parser.evaluator.result.StrValue;
import org.uva.sea.ql.parser.evaluator.result.Value;

public class TextField extends InputControl {
	private final JTextField textField;
	
	public TextField() {
		textField = new JTextField(5);
		
		setupDocumentListener();
	}
	
	private void setupDocumentListener() {
		Document document = getTextField().getDocument();
		document.addDocumentListener(new DocumentListener() {
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
		});
	}

	@Override
	public Value getValue() {
		return new StrValue(getTextField().getText());
	}
	
	private JTextField getTextField() {
		return textField;
	}

	@Override
	public JComponent getWidget() {
		return getTextField();
	}

}
