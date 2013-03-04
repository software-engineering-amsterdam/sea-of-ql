package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.gui.FormPanel;

public class CheckBoxActionListener extends QLActionListener {

	private JCheckBox checkBox;

	public CheckBoxActionListener(FormPanel formPanel,
			Map<Identifier, QLValue> identifierValueMap, Identifier identifier,
			JCheckBox checkBox) {
		super(formPanel, identifierValueMap, identifier);
		this.checkBox = checkBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BooleanLiteral booleanLiteral = new BooleanLiteral(
				checkBox.isSelected());
		this.identifierValueMap.put(this.identifier, booleanLiteral);
		super.updateFormPanel();
	}
}
