package org.uva.sea.ql.ui.components;

import javax.swing.JComponent;

public abstract class BaseComponent {

	public abstract JComponent getComponent();
	public abstract String getArgs();
	public abstract void setVisible(boolean visible);
	
}
