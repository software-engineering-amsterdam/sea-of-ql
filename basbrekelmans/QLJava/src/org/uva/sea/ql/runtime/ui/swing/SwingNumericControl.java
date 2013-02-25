package org.uva.sea.ql.runtime.ui.swing;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.runtime.ui.INumericControl;
import org.uva.sea.ql.runtime.values.Value;

abstract class SwingNumericControl implements INumericControl {
	private final Variable variable;

	private final NumberFormat format;

	private JFormattedTextField textField;

	private Box container;

	protected SwingNumericControl(final Variable variable,
			final NumberFormat format) {
		this.variable = variable;
		this.format = format;
		this.initializeComponent();
		this.initializeVariable();
	}

	@Override
	public Box getUnderlyingComponent() {
		return this.container;
	}

	protected Variable getVariable() {
		return this.variable;
	}

	private void initializeComponent() {

		this.textField = new JFormattedTextField(this.format);
		final Dimension minSize = this.textField.getMinimumSize();
		this.textField.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				minSize.height));
		this.textField.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void changedUpdate(final DocumentEvent de) {
						SwingNumericControl.this.onUIChanged();
					}

					@Override
					public void insertUpdate(final DocumentEvent de) {
						SwingNumericControl.this.onUIChanged();
					}

					@Override
					public void removeUpdate(final DocumentEvent de) {
						SwingNumericControl.this.onUIChanged();
					}
				});

		this.container = Box.createVerticalBox();
		this.container.add(Box.createVerticalGlue());
		this.container.add(this.textField);
		this.container.add(Box.createVerticalGlue());
	}

	private void initializeVariable() {
		this.variable.addObserver(new Observer() {

			@Override
			public void update(final Observable arg0, final Object arg1) {
				SwingNumericControl.this.onVariableChanged();
			}

		});
	}

	@Override
	public boolean isEnabled() {
		return this.textField.isEnabled();
	}

	private void onUIChanged() {
		if (this.isEnabled()) {
			this.onUIValueChanged(this.textField.getText());
		}
	}

	abstract void onUIValueChanged(String value);

	private void onVariableChanged() {
		if (!this.isEnabled()) {
			final Value value = this.variable.getValue();
			if (value == Value.UNSET_VALUE) {
				this.textField.setText(null);
			} else {
				this.textField.setText(value.getValue().toString());
			}
		}
	}

	@Override
	public void setEnabled(final boolean value) {
		this.textField.setEnabled(value);

	}
}
