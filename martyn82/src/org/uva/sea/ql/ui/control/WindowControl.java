package org.uva.sea.ql.ui.control;

abstract public class WindowControl {
	abstract public Object getInnerControl();
	abstract public void setTitle( String title );
	abstract public void addControl( PanelControl panel );
	abstract public void pack();
	abstract public void show();
	abstract public void hide();
	abstract public void close();
}
