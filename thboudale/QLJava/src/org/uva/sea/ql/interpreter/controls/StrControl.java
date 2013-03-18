package org.uva.sea.ql.interpreter.controls;

import javax.swing.JComponent;
import javax.swing.JTextField;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.evaluator.values.StrValue;
import org.uva.sea.ql.interpreter.ObservableQuestion;

public class StrControl extends AControl {
	private final JTextField ctrl;
	
	public StrControl() {
		this.ctrl = new JTextField("", 10);
	}
	
	public void setEditable(boolean isEditable) {
		ctrl.setEditable(isEditable);		
	}
		
	@Override
	public void setValue(AValue value) {
		ctrl.setText(value.toString());
	}
	
	@Override
	public AValue getValue() {
		return new StrValue(ctrl.getText());
	}

	@Override
	public void addListener(ObservableQuestion obs) {
		ctrl.addActionListener(obs);
		ctrl.addKeyListener(obs);
	}

	@Override
	public JComponent getControl() {
		return ctrl;
	}
}