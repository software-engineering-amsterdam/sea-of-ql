package khosrow.uva.sea.ql.ui.controls;

import java.awt.Component;

import javax.swing.JLabel;

import khosrow.uva.sea.ql.values.Value;

public class LabelControl extends Control {
	private final JLabel component;
	
	public LabelControl (String text) {
		this.component = new JLabel(text);
	}

	@Override
	public Component getComponent() {		
		return component;
	}

	@Override
	public void setValue(Value value) {		
		component.setText(value.toString());
	}

	@Override
	public void setVisible(boolean isVisible) {
		component.setVisible(isVisible);
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		component.setEnabled(isEnabled);
	}

}
