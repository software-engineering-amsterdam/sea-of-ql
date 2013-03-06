package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literals.IntLiteral;
import org.uva.sea.ql.ast.literals.QLValue;
import org.uva.sea.ql.gui.FormPanel;

public class NumericTextFieldActionListener extends QLActionListener {

	private JTextField textField;

	public NumericTextFieldActionListener(FormPanel formPanel,
			Map<Identifier, QLValue> identifierValueMap, Identifier identifier,
			JTextField textField) {
		super(formPanel, identifierValueMap, identifier);
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer intValue = 0;
		try {
			intValue = Integer.parseInt(textField.getText());
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,
					"Please enter an integer value for: ");
		}

		IntLiteral integerLiteral = new IntLiteral(intValue);

		this.identifierValueMap.put(this.identifier, integerLiteral);
		super.updateFormPanel();
	}

}
