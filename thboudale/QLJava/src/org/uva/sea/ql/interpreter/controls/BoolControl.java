package org.uva.sea.ql.interpreter.controls;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.evaluator.values.BoolValue;
import org.uva.sea.ql.interpreter.ObservableQuestion;

public class BoolControl extends AControl {
	private final JCheckBox ctrl;
	
	public BoolControl() {
		this.ctrl = new JCheckBox();
	}
	
	@Override
	public void setValue(AValue value) {
		ctrl.setSelected(((BoolValue)value).getValue());
	}
	
	@Override
	public AValue getValue() {
		return new BoolValue(ctrl.isSelected());
	}
	
	@Override
	public void addListener(ObservableQuestion obs) {
		ctrl.addActionListener(obs);
	}

	@Override
	public JComponent getControl() {
		return ctrl;
	}
}