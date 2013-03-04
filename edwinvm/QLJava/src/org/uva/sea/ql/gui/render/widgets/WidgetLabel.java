package org.uva.sea.ql.gui.render.widgets;

import java.awt.Dimension;

import javax.swing.JLabel;

import org.uva.sea.ql.ast.values.Str;

public class WidgetLabel {

	private final JLabel _label;

	public WidgetLabel(Str label) {
		_label = new JLabel(label.getValue());
		_label.setPreferredSize(new Dimension(320, 20));  
	}
	
	public JLabel getLabel() {
		return _label;
	}
	
}