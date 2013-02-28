package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.values.Value;

public class TextInputWidget extends Widget {

	private final JTextField _widget;
	
	public TextInputWidget() {
		_widget = new JTextField(15);
	}

	@Override
	public void setValue(Value value) {
		_widget.setText(((Str)value).getValue());
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