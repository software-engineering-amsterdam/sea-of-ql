package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionListener;
import java.util.Map;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.QLValue;

public abstract class ButtonListener implements ActionListener {

	protected Map<Identifier, QLValue> identifierValueMap;

	public ButtonListener(Map<Identifier, QLValue> identifierValueMap) {
		this.identifierValueMap = identifierValueMap;
	}
}
