package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Value;

public class CheckBoxWidget extends Widget {

	private final JCheckBox _widget;
	
	public CheckBoxWidget() {
		_widget = new JCheckBox();
	}

	@Override
	public void setValue(Value value) {
		_widget.setSelected(((Bool)value).getValue());
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