package org.uva.sea.ql.gui.widget;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Primitive;

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

	@Override
	public Primitive getValue() {
		return new Bool(chkbox.getState());
	}
	
}
