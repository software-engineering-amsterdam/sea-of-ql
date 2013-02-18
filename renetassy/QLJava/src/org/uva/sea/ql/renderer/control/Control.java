package org.uva.sea.ql.renderer.control;

import javax.swing.JComponent;

import org.uva.sea.ql.values.Value;

public abstract class Control {
	
	public abstract Value getValue();
	public abstract JComponent getWidget();

}
