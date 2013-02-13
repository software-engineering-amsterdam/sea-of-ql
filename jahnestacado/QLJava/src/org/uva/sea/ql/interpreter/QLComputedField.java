package org.uva.sea.ql.interpreter;

import java.awt.Color;

import javax.swing.JTextField;

public class QLComputedField {
	private final JTextField txtField;
	private final static String txtFieldId = "QLTEXTFIELD";

	private QLComputedField() {
		txtField = new JTextField(8);
		txtField.setName(txtFieldId);
	}

	public static JTextField getQLComputedField() {
		QLComputedField qlComputedField = new QLComputedField();
		qlComputedField.setSettings();
		return qlComputedField.getComputedField();
	}

	private JTextField getComputedField() {
		return txtField;
	}

	private void setSettings() {
		txtField.setForeground(Color.blue);
		txtField.setBackground(Color.white);
		txtField.setHorizontalAlignment(JTextField.CENTER);
		txtField.setEditable(false);
	}

}
