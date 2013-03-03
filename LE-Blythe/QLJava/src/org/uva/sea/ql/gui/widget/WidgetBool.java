package org.uva.sea.ql.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.eval.value.BoolVal;
import org.uva.sea.ql.eval.value.UndefinedVal;
import org.uva.sea.ql.eval.value.Value;

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
	public JComponent getControl(){
		initialized = true;
		return chkbox;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		fireChangeEvent();
	}

	@Override
	public Value getValue() {
		return initialized ? new BoolVal(chkbox.isSelected()) : new UndefinedVal();
	}
	
}
