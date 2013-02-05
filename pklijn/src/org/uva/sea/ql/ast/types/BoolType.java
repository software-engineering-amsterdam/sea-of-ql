package org.uva.sea.ql.ast.types;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

import net.miginfocom.swing.MigLayout;

public class BoolType extends Type implements ActionListener {

	private JRadioButton buttonTrue, buttonFalse;
	
	@Override
	public String toString() {
		return "Boolean";
	}
	
	@Override
	public JComponent getAnswerField(boolean enabled) {
		JPanel container = new JPanel(new MigLayout("ins 1"));
		ButtonGroup bg = new ButtonGroup();
		buttonTrue = new JRadioButton("Yes");
		buttonFalse = new JRadioButton("No");
		buttonTrue.addActionListener(this);
		buttonFalse.addActionListener(this);
		buttonTrue.setEnabled(enabled);
		buttonFalse.setEnabled(enabled);
		bg.add(buttonTrue);
		bg.add(buttonFalse);
		container.add(buttonTrue);
		container.add(buttonFalse);
		return container;
	}

	@Override
	public boolean hasValue() {
		return (buttonTrue.isSelected() || buttonFalse.isSelected());
	}
	
	@Override
	public Value getAnswerFieldValue(JComponent answerComponent) {
		return new BoolValue(buttonTrue.isSelected());
	}
	
	@Override
	public void setAnswerFieldValue(Value value) {
		if (value.getClass().equals(new BoolValue().getClass())) {
			if (((BoolValue)value).getValue()) {
				buttonTrue.setSelected(true);
			}
			else {
				buttonFalse.setSelected(true);
			}
		}
		else {
			throw new IllegalArgumentException("The value given is not of the type Boolean");
		}
	}
	
	@Override
	public Value getDefaultValue() {
		return new BoolValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((buttonTrue.isSelected() || buttonFalse.isSelected()) && form != null) {
			form.eval();
		}
	}
}
