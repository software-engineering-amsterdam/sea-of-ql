package org.uva.sea.ql.gui.widget;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.primitive.Bool;
import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Undefined;

public class WidgetBool extends Widget implements ItemListener{
	private JCheckBox chkbox;
	
	//tracks whether the checkbox has been clicked before
	boolean initialized;
	
	public WidgetBool(){
		super();
		
		chkbox = new JCheckBox();
		chkbox.addItemListener(this);
		this.initialized = false;
	}

	@Override
	public Component getComponent(){
		initialized = true;
		return chkbox;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		fireChangeEvent();
	}

	@Override
	public Primitive getValue() {
		return initialized ? new Bool(chkbox.isSelected()) : new Undefined();
	}
	
}
