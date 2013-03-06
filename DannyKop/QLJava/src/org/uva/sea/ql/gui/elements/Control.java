package org.uva.sea.ql.gui.elements;

import javax.swing.JComponent;

public abstract class Control  {
	
	private final JComponent comp;
	
	public Control(JComponent c) {
		this.comp = c;
	}
	
	public JComponent getComponent(){
		return this.comp;
	}

}
