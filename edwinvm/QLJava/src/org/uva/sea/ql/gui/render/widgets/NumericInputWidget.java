package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Value;

public class NumericInputWidget extends Widget {

	private final JTextField _widget;
	
	public NumericInputWidget() {
		_widget = new JFormattedTextField(NumberFormat.getInstance());
		_widget.setColumns(10);
		_widget.setHorizontalAlignment(JTextField.RIGHT);
	}

	@Override
	public void setValue(Value value) {
		_widget.setText(((Int)value).getValue().toString());
	}
	
	@Override
	public Component getWidget() {
		return _widget;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_widget.setEnabled(enabled);
	}
	
}