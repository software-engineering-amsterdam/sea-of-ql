package org.uva.sea.ql.interpreter.controls;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.uva.sea.ql.evaluator.values.AValue;
import org.uva.sea.ql.evaluator.values.IntValue;
import org.uva.sea.ql.evaluator.values.UndefinedValue;
import org.uva.sea.ql.interpreter.ObservableQuestion;

public class IntControl extends AControl {
	private final JTextField ctrl;
	
	public IntControl() {
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
		try {
			return ctrl.getText().isEmpty() ? new IntValue(0) : new IntValue(Integer.parseInt(ctrl.getText()));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(ctrl, "The field accepts only integers.");
			return new UndefinedValue();
		}
	}

	@Override
	public void addListener(ObservableQuestion obs) {
		ctrl.addKeyListener(obs);
	}

	@Override
	public JComponent getControl() {
		return ctrl;
	}
}