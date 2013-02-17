package org.uva.sea.ql.gui.component;

import java.awt.Label;

import org.uva.sea.ql.util.Environment;


public class Form extends Statement {

	private static final long serialVersionUID = 1L;
	
	private Label name;
	private Block block;
	
	public Form(String name, Block block, Environment environment){
		super(environment);
		
		this.name = new Label(name);
		this.block = block;
	}

	
	@Override
	public boolean evaluateVisibility() {
		return true;
	}	

}
