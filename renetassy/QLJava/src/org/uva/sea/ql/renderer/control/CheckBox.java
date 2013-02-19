package org.uva.sea.ql.renderer.control;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.renderer.ObservableQuestion;
import org.uva.sea.ql.values.Bool;
import org.uva.sea.ql.values.Value;

public class CheckBox extends Control {
	
	private final JCheckBox widget;

	public CheckBox() {
		widget = new JCheckBox();
	}
	
	@Override
	public Value getValue() {
		
		if(widget.isSelected()) {
			return new Bool(true);
		}
		
		return new Bool(false);
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public void addListener(ObservableQuestion obsQuestion) {
		widget.addActionListener(obsQuestion);
	}

}
