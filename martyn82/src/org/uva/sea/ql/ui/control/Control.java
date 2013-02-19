package org.uva.sea.ql.ui.control;

abstract public class Control {
	abstract public Object getInnerControl();
	abstract public void setEnabled( boolean enabled );
	abstract public void setVisible( boolean visible );
}
