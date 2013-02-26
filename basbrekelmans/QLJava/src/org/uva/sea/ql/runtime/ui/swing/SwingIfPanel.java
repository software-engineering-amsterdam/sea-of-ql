package org.uva.sea.ql.runtime.ui.swing;

import org.uva.sea.ql.runtime.RuntimeValue;

public class SwingIfPanel extends SwingPanel {

	public SwingIfPanel(final RuntimeValue variable) {
		super(variable);

	}

	@Override
	void onVariableChanged(final Boolean value) {
		this.getUnderlyingComponent().setVisible(value);
	}

}
