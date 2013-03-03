package org.uva.sea.ql.gui.listeners;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.types.literals.StringLiteral;

public class TextFieldActionListener extends QLActionListener {

	private JTextField textField;

	public TextFieldActionListener(JPanel panel, JTextField textField) {
		super(panel);
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringLiteral stringLiteral = new StringLiteral(textField.getText());

	}
}
