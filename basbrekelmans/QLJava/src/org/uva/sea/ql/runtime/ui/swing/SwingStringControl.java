package org.uva.sea.ql.runtime.ui.swing;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.runtime.RuntimeValue;
import org.uva.sea.ql.runtime.ui.IControl;

class SwingStringControl implements IControl {

	private final RuntimeValue variable;
	private final JTextField textField;

	public SwingStringControl(final RuntimeValue variable) {
		this.variable = variable;
		this.textField = new JTextField();
		this.textField.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void changedUpdate(final DocumentEvent de) {
						SwingStringControl.this.onDocumentChanged();
					}

					@Override
					public void insertUpdate(final DocumentEvent de) {
						SwingStringControl.this.onDocumentChanged();
					}

					@Override
					public void removeUpdate(final DocumentEvent de) {
						SwingStringControl.this.onDocumentChanged();
					}
				});
	}

	@Override
	public JTextField getUnderlyingComponent() {
		return this.textField;
	}

	@Override
	public boolean isEnabled() {
		return this.textField.isEnabled();
	}

	private void onDocumentChanged() {
		this.variable.setValue(new org.uva.sea.ql.runtime.values.StringValue(
				this.textField.getText()));
	}

	@Override
	public void setEnabled(final boolean value) {
		this.textField.setEnabled(value);

	}

}
