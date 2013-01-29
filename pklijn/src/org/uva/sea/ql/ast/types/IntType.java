package org.uva.sea.ql.ast.types;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class IntType extends Type implements ActionListener {

	private TextField answerField;
	@Override
	public String toString() {
		return "Integer";
	}
	
	@Override
	public Component getAnswerField(boolean enabled) {
		answerField = new TextField("int");
		answerField.setEnabled(enabled);
		answerField.addActionListener(this);
		return answerField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer value;
		try {
			value = Integer.parseInt(answerField.getText());
			System.out.println(value);
		}
		catch (NumberFormatException nfe) {
			answerField.setText("");
			JOptionPane.showMessageDialog(null, "The value should be an Integer!");
		}
	}
}
