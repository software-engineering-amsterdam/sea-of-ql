package org.uva.sea.ql.gui.widget;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Primitive;

public class WidgetBool extends Widget implements ItemListener{
	private JCheckBox chkbox;
	
	public WidgetBool(){
		super();
		
		chkbox = new JCheckBox();
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

	@Override
	public Primitive getValue() {
		return new Bool(chkbox.isSelected());
	}


	
}
