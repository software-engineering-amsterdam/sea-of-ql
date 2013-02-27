package org.uva.sea.ql.ui.components;

import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Value;


public class BoolComponent extends ActiveComponent {
	
	private final JCheckBox answerField;
	
	public BoolComponent() {
		super("wrap");
		this.answerField = new JCheckBox();
	}
	
	@Override
	public void updateValue(Value newValue) {
		answerField.setSelected(((BoolVal)newValue).getValue());
	}

	@Override
	public Value getValue() {
		return new BoolVal(answerField.isSelected());
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
