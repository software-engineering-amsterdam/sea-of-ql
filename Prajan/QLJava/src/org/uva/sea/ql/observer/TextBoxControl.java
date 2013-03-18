package org.uva.sea.ql.observer;

import javax.swing.JTextField;

import org.uva.sea.ql.visitor.Value;

public class TextBoxControl extends JTextField implements Control {

	@Override
	public void setValue(Value value) {
		setText(value.toString());
	}
}
