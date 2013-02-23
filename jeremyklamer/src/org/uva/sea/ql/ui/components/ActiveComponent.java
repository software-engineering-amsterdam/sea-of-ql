package org.uva.sea.ql.ui.components;


import java.awt.event.ActionListener;

import org.uva.sea.ql.interpreter.Value;

public abstract class ActiveComponent extends BaseComponent {

	protected final String args; 
	
	public ActiveComponent(String args) {
		this.args = args;
	}
	
	public abstract void updateValue(Value newValue);
	public abstract Value getValue();
	public abstract void addActionListener(ActionListener listener);
	public abstract void setEnabled(boolean enabled);
			
	@Override
	public String getArgs() {
		return args;
	}

}
