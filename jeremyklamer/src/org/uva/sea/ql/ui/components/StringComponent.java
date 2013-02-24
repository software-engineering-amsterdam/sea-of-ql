package org.uva.sea.ql.ui.components;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.interpreter.StringVal;
import org.uva.sea.ql.interpreter.Value;

public class StringComponent extends ActiveComponent{
	
	private final static int UI_COMPONENT_WIDTH = 150;
	private final JTextField answerField;
	
	public StringComponent() {
		super("wrap, width :"+ UI_COMPONENT_WIDTH + ":");
		this.answerField = new JTextField();
		answerField.setSize(UI_COMPONENT_WIDTH, answerField.getHeight());
	}

	@Override
	public void updateValue(Value newValue) {
		answerField.setText(((StringVal)newValue).getValue());
	}

	@Override
	public Value getValue() {
		return new StringVal(answerField.getText());
	}

	@Override
	public void addActionListener(ActionListener listener) {
		answerField.addActionListener(listener);
	}

	@Override
	public void setEnabled(boolean enabled) {
		answerField.setEnabled(enabled);		
	}

	@Override
	public JComponent getComponent() {
		return answerField;
	}

	@Override
	public void setVisible(boolean visible) {
		answerField.setVisible(visible);
	}
}
