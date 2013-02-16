package org.uva.sea.ql.gui;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class WidgetBool extends Widget implements ItemListener{
	private Checkbox chkbox;
	
	public WidgetBool(){
		super();
		chkbox = new Checkbox();
		chkbox.addItemListener(this);
	}

	
	@Override
	public Component getComponent(){
		return chkbox;
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		fireChangeEvent();
	}
	
}
