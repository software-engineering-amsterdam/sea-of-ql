package org.uva.sea.ql.gui.render.widgets;

import java.awt.Component;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.gui.observe.AnswerableQuestionObservable;

public class TextInputWidget extends Widget {

	private final JTextField _widget;
	
	public TextInputWidget() {
		_widget = new JTextField(15);
	}

	@Override
	public Value getValue() {
		return new Str(_widget.getText());
	}
	
	@Override
	public void setValue(Value value) {
		_widget.setText(((Str)value).getValue());
	}

	@Override
	public void setDefaultValue() {
		_widget.setText("");
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