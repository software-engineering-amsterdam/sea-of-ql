package org.uva.sea.ql.gui;

import java.awt.Component;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.values.Bool;

public class BooleanToWidget extends Control {

	private final JCheckBox checkBox;

	public BooleanToWidget() {
		checkBox = new JCheckBox();
	}

	@Override
	public Value getValue() {
		return (checkBox.isSelected() ? new Bool(true) : new Bool(false));
	}

	@Override
	public Component getComponent() {
		return checkBox;
	}

	@Override
	public void listener(ObservableSimpleQuestion observable) {
		checkBox.addActionListener(observable);
	}

	@Override
	public void setValueOfComponent(Value value) {
		if (value instanceof Bool) {
			checkBox.setSelected(((Bool) value).getValue());
		}
	}

}
