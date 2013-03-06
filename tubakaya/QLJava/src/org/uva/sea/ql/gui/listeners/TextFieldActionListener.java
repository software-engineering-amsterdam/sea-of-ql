package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.gui.FormPanel;

public class TextFieldActionListener extends QLActionListener {

	private JTextField textField;

	public TextFieldActionListener(FormPanel formPanel,
			Map<Identifier, QLValue> identifierValueMap, Identifier identifier,
			JTextField textField) {
		super(formPanel, identifierValueMap, identifier);
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringLiteral stringLiteral = new StringLiteral(textField.getText());
		this.identifierValueMap.put(this.identifier, stringLiteral);
		super.updateFormPanel();
	}
}
