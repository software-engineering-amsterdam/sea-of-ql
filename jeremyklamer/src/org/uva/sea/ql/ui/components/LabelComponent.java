package org.uva.sea.ql.ui.components;


import javax.swing.JComponent;
import javax.swing.JLabel;

public class LabelComponent extends BaseComponent {
	
	private final JLabel textLabel;
	private final String args; 
	
	public LabelComponent(String text ,String args) {
		this.textLabel = new JLabel(text);
		this.args = args;
	}
	
	@Override
	public JComponent getComponent() {
		return textLabel;
	}
	@Override
	public String getArgs() {
		return args; 
	}

	@Override
	public void setVisible(boolean visible) {
		textLabel.setVisible(visible);	
	}
	
}
