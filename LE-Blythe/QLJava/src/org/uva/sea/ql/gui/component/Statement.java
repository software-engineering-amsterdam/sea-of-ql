package org.uva.sea.ql.gui.component;

import java.awt.Panel;

import org.uva.sea.ql.util.Environment;

public abstract class Statement extends Panel{
	
	private static final long serialVersionUID = 1L;
	
	protected Environment environment; 
	
	public Statement(Environment env){
		super();
		this.environment = env;
	}
	
	public abstract boolean evaluateVisibility();
}
