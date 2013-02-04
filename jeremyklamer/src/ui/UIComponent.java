package ui;

import java.awt.Component;

public class UIComponent {

	private final Component component; 
	private final String args; 
	
	public UIComponent(Component component, String args){
		this.component = component;
		this.args = args; 
	}

	public Component getComponent() {
		return component;
	}

	public String getArgs() {
		return args;
	}
	
}
