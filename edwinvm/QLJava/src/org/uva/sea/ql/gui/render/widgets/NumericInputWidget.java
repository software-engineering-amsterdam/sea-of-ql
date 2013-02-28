package org.uva.sea.ql.gui.render.widgets;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Value;

public class NumericInputWidget extends Widget {

	private final JTextField _widget;
	
	public NumericInputWidget(JTextField widget) {
		super(widget);
		_widget = widget;
	}

	@Override
	public void setValue(Value value) {
		_widget.setText(((Int)value).getValue().toString());
	}
}