package org.uva.sea.ql.runtime.ui.swing;

import org.uva.sea.ql.runtime.RuntimeValue;

class SwingElsePanel extends SwingPanel {

	public SwingElsePanel(final RuntimeValue variable) {
		super(variable);
	}

	@Override
	void onVariableChanged(final Boolean value) {
		this.getUnderlyingComponent().setVisible(!value);

	}

}
