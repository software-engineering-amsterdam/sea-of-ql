package org.uva.sea.ql.gui.control;

import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class CheckBox extends Control {

	private JCheckBox checkbox;
	
	public CheckBox(){
		this.checkbox = new JCheckBox();
	}
	
	
	public void addItemListener(ItemListener l){
		checkbox.addItemListener(l);
	}
	
	
	public boolean isSelected(){
		return checkbox.isSelected();
	}
	
	
	@Override
	protected JComponent getComponent() {
		return checkbox;
	}

	@Override
	public void setVisible(boolean b) {
		checkbox.setVisible(b);
	}
}
