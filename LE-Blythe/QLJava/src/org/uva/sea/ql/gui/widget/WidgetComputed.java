package org.uva.sea.ql.gui.widget;


import javax.swing.JComponent;
import javax.swing.JLabel;

import org.uva.sea.ql.eval.value.UndefinedVal;
import org.uva.sea.ql.eval.value.Value;

public class WidgetComputed extends Widget {
	
	private JLabel label;
	private Value value;
	
	public WidgetComputed(){
		super();
		this.label = new JLabel();
		this.value = new UndefinedVal();
	}
	
	
	public void setValue(Value value){
		this.value = value;
		this.label.setText(value.toString());
		
		fireChangeEvent();
	}

	@Override
	public JComponent getControl() {
		return label;
	}

	@Override
	public Value getValue() {
		return value;
	}
}
