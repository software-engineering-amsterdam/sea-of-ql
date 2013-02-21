package org.uva.sea.ql.ui.components;

import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class IntComponent extends ActiveComponent{

	private final static int UI_COMPONENT_WIDTH = 100;
	private final JTextField answerField;
	
	public IntComponent() {
		super("wrap, width :"+ UI_COMPONENT_WIDTH + ":");
		this.answerField = new JTextField();
	}
	
	@Override
	public void updateValue(Value newValue) {
		answerField.setText("" + ((IntVal)newValue).getValue());
	}
	
	@Override
	public Value getValue() {
		return new IntVal(Integer.parseInt(answerField.getText()));
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
