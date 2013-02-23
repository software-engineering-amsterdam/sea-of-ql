package org.uva.sea.ql.gui.widget;

import java.awt.Component;

import javax.swing.JLabel;

import org.uva.sea.ql.ast.primitive.Primitive;
import org.uva.sea.ql.ast.primitive.Undefined;

public class WidgetComputed extends Widget {
	
	private JLabel label;
	private Primitive value;
	
	public WidgetComputed(){
		super();
		this.label = new JLabel();
		this.value = new Undefined();
	}
	
	
	public void setValue(Primitive value){
		this.value = value;
		this.label.setText(value.toString());
		
		fireChangeEvent();
	}

	@Override
	public Component getComponent() {
		return label;
	}

	@Override
	public Primitive getValue() {
		return value;
	}
}
