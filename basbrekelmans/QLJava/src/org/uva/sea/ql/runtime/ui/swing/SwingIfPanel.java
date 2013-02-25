package org.uva.sea.ql.runtime.ui.swing;

import org.uva.sea.ql.runtime.Variable;

public class SwingIfPanel extends SwingPanel {

	public SwingIfPanel(final Variable variable) {
		super(variable);

	}

	@Override
	void onVariableChanged(final Boolean value) {
		this.getUnderlyingComponent().setVisible(value);
	}

}
