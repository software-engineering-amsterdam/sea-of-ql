package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.gui.observe.AnswerableQuestionObservable;

public class CheckBoxWidget extends Widget {

	private final JCheckBox _widget;
	
	public CheckBoxWidget() {
		_widget = new JCheckBox();
	}

	@Override
	public Value getValue() {
		return new Bool(_widget.isSelected());
	}
	
	@Override
	public void setValue(Value value) {
		_widget.setSelected(((Bool)value).getValue());
	}
	
	@Override
	public void setDefaultValue() {
		_widget.setSelected(false);
	}
	
	@Override
	public Component getWidget() {
		return _widget;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_widget.setEnabled(enabled);
	}
	
	@Override
	public void addListener(AnswerableQuestionObservable observable) {
		_widget.addActionListener(observable);
	}
	
}