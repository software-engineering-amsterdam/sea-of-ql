package org.uva.sea.ql.gui.render.widgets;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Value;

public class CheckBoxWidget extends Widget {

	private final JCheckBox _widget;
	
	public CheckBoxWidget(JCheckBox widget) {
		super(widget);
		_widget = widget;
	}

	@Override
	public void setValue(Value value) {
		_widget.setSelected(((Bool)value).getValue());
	}
}