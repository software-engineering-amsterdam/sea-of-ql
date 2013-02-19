package org.uva.sea.ql.rendering.controls;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.evaluation.values.Value;

public abstract class Field extends Control {
	
	protected final JTextField jTextField;
	private static final int WIDTH = 15;
	
	public Field() {
		jTextField = new JTextField(WIDTH);
	}
	
	@Override
	public abstract Value getValue();
	
	@Override
	public JComponent getControl() {
		return jTextField;
	}

}
