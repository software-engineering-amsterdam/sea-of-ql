package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class ScrollPane extends Control {
	
	private JScrollPane pane;
	
	public ScrollPane(Control ctrl){
		this.pane = new JScrollPane(ctrl.getComponent());
	}
	
	
	@Override
	protected JComponent getComponent() {
		return pane;
	}

	@Override
	public void setVisible(boolean b) {
		pane.setVisible(b);
	}
	
	
	
	

}
