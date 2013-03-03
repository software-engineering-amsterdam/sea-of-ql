package org.uva.sea.ql.interpreter;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

public class CheckBox extends Control {

	private final JCheckBox jCheckBox;

	public CheckBox() {
		jCheckBox = new JCheckBox();
	}
	
	@Override
	public JComponent getControl() {
		return jCheckBox;
	}
	
	@Override
	public void addListener(ObservableQuestion observableQuestion) {
		jCheckBox.addActionListener(observableQuestion);		
	}

	@Override
	public void setValue(Value value) {
		if (value instanceof BoolValue)
		jCheckBox.setSelected(((BoolValue)value).getValue());
	}

	@Override
	public Value getValue() {
		if(jCheckBox.isSelected()){
			return new BoolValue(true);
		}else{
			return new BoolValue(false);
		}
	}

	@Override
	public void addListener(ObservableComputed observableComputed) {
		jCheckBox.addActionListener(observableComputed);
		jCheckBox.addFocusListener(observableComputed);
	}

}
