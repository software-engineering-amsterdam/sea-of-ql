package org.uva.sea.ql.interpreter;

import javax.swing.JComponent;

public class FormElement {
	
	private JComponent formComponent;
	private String properties;
	
	public FormElement(JComponent formComponent, String properties) {
		this.formComponent = formComponent;
		this.properties = properties;
	}
	
	public JComponent getFormComponent() {
		return formComponent;
	}
	
	public String getProperties() {
		return properties;
	}
}
