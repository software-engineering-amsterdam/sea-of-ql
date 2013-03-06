package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionListener;
import java.util.Map;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.gui.FormPanel;

public abstract class QLActionListener implements ActionListener {

	protected FormPanel formPanel;
	protected Map<Identifier, QLValue> identifierValueMap;
	protected Identifier identifier;

	public QLActionListener(FormPanel formPanel,
			Map<Identifier, QLValue> identifierValueMap, Identifier identifier) {
		this.formPanel = formPanel;
		this.identifierValueMap = identifierValueMap;
		this.identifier = identifier;
	}

	protected void updateFormPanel() {
		formPanel.resetContainer();
		formPanel.renderForm(this.identifierValueMap);
	}
}
