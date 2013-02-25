package org.uva.sea.ql.gui.control;

import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Panel extends Control {

	private JPanel panel;

	public Panel(){
		this.panel = new JPanel();
	}
	
	
	public Panel(String layoutStr){
		this.panel = new JPanel(new MigLayout(layoutStr));
	}


	public void add(Control cmp) {
		panel.add(cmp.getComponent());
	}
	
	
	public void add(Control cmp, String layoutStr) {
		panel.add(cmp.getComponent(), layoutStr);
	}

	
	@Override
	protected JComponent getComponent() {
		return panel;
	}
	
	@Override
	public void setVisible(boolean b) {
		panel.setVisible(b);
	}
}
