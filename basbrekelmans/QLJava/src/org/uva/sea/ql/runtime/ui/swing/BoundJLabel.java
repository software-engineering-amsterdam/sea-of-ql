package org.uva.sea.ql.runtime.ui.swing;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import org.uva.sea.ql.runtime.RuntimeValue;
import org.uva.sea.ql.runtime.values.Value;

/*
 * Supports one way binding from a variable to a label; when the variable 
 * value changes, the label gets updated accordingly.
 */
class BoundJLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private final RuntimeValue variable;

	public BoundJLabel(final RuntimeValue variable) {
		this.variable = variable;
		this.onValueChanged();
		this.variable.addObserver(new Observer() {
			@Override
			public void update(final Observable o, final Object arg) {
				BoundJLabel.this.onValueChanged();

			}
		});
	}

	private void onValueChanged() {
		final Value value = this.variable.getValue();
		if (value == Value.UNSET_VALUE) {
			this.setText(null);
		} else {
			this.setText(value.getValue().toString());
		}
	}
}
