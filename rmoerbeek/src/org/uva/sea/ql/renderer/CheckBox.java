package org.uva.sea.ql.renderer;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.evaluator.values.Value;
import org.uva.sea.ql.evaluator.values.BoolValue;

public class CheckBox extends Control {
	
	private final JCheckBox checkBox;
	
	public CheckBox() {
		this.checkBox = new JCheckBox();
	}

	@Override
	public void setValue(Value val) {
		checkBox.setSelected(((BoolValue) val).getValue());
	}

	@Override
	public Value getValue() {
		return new BoolValue(checkBox.isSelected());
	}

	@Override
	public void setVisible(boolean v) {
		checkBox.setVisible(v);	
	}

	@Override
	public JComponent getControl() {
		return checkBox;
	}

	@Override
	public void addListener(QuestionObservable qo) {
		checkBox.addActionListener(qo);
		
	}

}
