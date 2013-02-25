package org.uva.sea.ql.runtime.ui.swing;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.runtime.Variable;
import org.uva.sea.ql.runtime.ui.IControl;
import org.uva.sea.ql.runtime.values.BooleanValue;
import org.uva.sea.ql.runtime.values.Value;

abstract class SwingPanel implements IControl {
	private final Variable variable;
	private final JPanel panel;

	public SwingPanel(final Variable variable) {
		this.variable = variable;
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
		variable.addObserver(new Observer() {

			@Override
			public void update(final Observable arg0, final Object arg1) {
				SwingPanel.this.update();
			}

		});
		this.update();
	}

	@Override
	public JPanel getUnderlyingComponent() {
		return this.panel;
	}

	@Override
	public boolean isEnabled() {
		return this.panel.isEnabled();
	}

	abstract void onVariableChanged(Boolean value);

	@Override
	public void setEnabled(final boolean value) {
		this.panel.setEnabled(value);
	}

	private void update() {
		Boolean result = false;
		final Value value = this.variable.getValue();
		if (value != Value.UNSET_VALUE) {
			result = ((BooleanValue) this.variable.getValue()).getValue();
		}
		this.onVariableChanged(result);
	}
}
