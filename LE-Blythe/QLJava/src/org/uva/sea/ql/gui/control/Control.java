package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;

public abstract class Control {

	//any class that inherits this base class can access the getComponent()
	//method.
	protected abstract JComponent getComponent();
	
	
	public abstract void setVisible(boolean b);
}
