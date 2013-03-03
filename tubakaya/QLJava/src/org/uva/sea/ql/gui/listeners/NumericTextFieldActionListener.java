package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.literals.IntLiteral;

public class NumericTextFieldActionListener extends QLActionListener {

	private JTextField textField;

	public NumericTextFieldActionListener(JPanel panel, JTextField textField) {
		super(panel);
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
	}

}
