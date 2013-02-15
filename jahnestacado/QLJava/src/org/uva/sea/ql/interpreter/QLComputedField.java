package org.uva.sea.ql.interpreter;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class QLComputedField {
	private final JTextField txtField;
	public final static String QL_COMPUTED_FIELD_ID = "QL_COMPUTED_FIELD_ID";

	private QLComputedField() {
		txtField = new JTextField(8);
		setSettings();
	}

	public static JTextField getQLComputedField() {
		QLComputedField qlComputedField = new QLComputedField();
		return qlComputedField.getComputedField();
	}

	private JTextField getComputedField() {
		return txtField;
	}

	private void setSettings() {
		txtField.setForeground(Color.orange);
		txtField.setBackground(Color.gray);
		txtField.setBorder(BorderFactory.createLineBorder(Color.white));
		txtField.setHorizontalAlignment(JTextField.CENTER);
		txtField.setEditable(false);
		txtField.setName(QL_COMPUTED_FIELD_ID);
	}

}
