package org.uva.sea.ql.gui.controls;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.eval.BooleanValue;
import org.uva.sea.ql.eval.Value;
import org.uva.sea.ql.interpreter.State;

public class RadioButton extends Control implements ChangeListener {

	private JRadioButton component;
	
	public RadioButton(Identifier identifier, State state) {
		super(identifier, state);
		component = new JRadioButton();
		component.addChangeListener(this);
	}

	public JComponent getUIComponent() {
		return component;
	}

	public void setEnabled(boolean enable) {
		component.setEnabled(enable);
	}

	public void setValue(Value value) {
		component.setSelected(((BooleanValue)value).getValue());
		setChanged();
		getState().putValue(getIdentifier(), value);
		getState().notify(getIdentifier());
	}
	
	public void stateChanged(ChangeEvent e) {
		setValue( new BooleanValue(component.isSelected()) );
	}
	
}