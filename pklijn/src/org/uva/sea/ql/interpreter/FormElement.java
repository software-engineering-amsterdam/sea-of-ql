package org.uva.sea.ql.interpreter;

import java.awt.Component;

public class FormElement {
	
	private Component formComponent;
	private String properties;
	
	public FormElement(Component formComponent, String properties) {
		this.formComponent = formComponent;
		this.properties = properties;
	}
	
	public Component getFormComponent() {
		return formComponent;
	}
	
	public String getProperties() {
		return properties;
	}
}
