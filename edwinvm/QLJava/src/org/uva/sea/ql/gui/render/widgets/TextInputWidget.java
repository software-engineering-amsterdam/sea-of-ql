package org.uva.sea.ql.gui.render.widgets;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.values.Value;

public class TextInputWidget extends Widget {

	private final JTextField _widget;
	
	public TextInputWidget(JTextField widget) {
		super(widget);
		_widget = widget;
	}

	@Override
	public void setValue(Value value) {
		_widget.setText(((Str)value).getValue());
	}
}